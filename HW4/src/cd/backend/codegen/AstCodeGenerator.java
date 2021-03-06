package cd.backend.codegen;

import static cd.Config.MAIN;
import static cd.backend.codegen.RegisterManager.STACK_REG;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import cd.Config;
import cd.Main;
import cd.backend.codegen.RegisterManager.Register;
import cd.ir.Ast.ClassDecl;
import cd.ir.Ast.MethodDecl;
import cd.ir.Ast.VarDecl;

public class AstCodeGenerator {

	protected RegsNeededVisitor rnv;

	protected ExprGenerator eg;
	protected StmtGenerator sg;

	//public int currentStackPointerOffset;
	public int oldBasePointer;

	public static HashMap<String, VTable> classTables = new HashMap<String, VTable>();

	protected final Main main;

	protected final AssemblyEmitter emit;
	protected final RegisterManager rm = new RegisterManager();

	protected static final String VAR_PREFIX = "var_";

	AstCodeGenerator(Main main, Writer out) {
		{
			initMethodData();
		}

		this.emit = new AssemblyEmitter(out);
		this.main = main;
		this.rnv = new RegsNeededVisitor();

		this.eg = new ExprGenerator(this);
		this.sg = new StmtGenerator(this);
	}

	protected void debug(String format, Object... args) {
		this.main.debug(format, args);
	}

	public static AstCodeGenerator createCodeGenerator(Main main, Writer out) {
		return new AstCodeGenerator(main, out);
	}

	/**
	 * Main method. Causes us to emit x86 assembly corresponding to {@code ast}
	 * into {@code file}. Throws a {@link RuntimeException} should any I/O error
	 * occur.
	 * 
	 * <p>
	 * The generated file will be divided into two sections:
	 * <ol>
	 * <li>Prologue: Generated by {@link #emitPrefix()}. This contains any
	 * introductory declarations and the like.
	 * <li>Body: Generated by {@link ExprGenerator}. This contains the main
	 * method definitions.
	 * </ol>
	 */
	public void go(List<? extends ClassDecl> astRoots) {

		// Emit some useful string constants:
		this.emit.emitRaw(Config.DATA_STR_SECTION);
		this.emit.emitLabel("STR_NL");
		this.emit.emitRaw(Config.DOT_STRING + " \"\\n\"");
		this.emit.emitLabel("STR_D");
		this.emit.emitRaw(Config.DOT_STRING + " \"%d\"");

		emitDataSection(astRoots); // Emit VTables (className + methods)

		this.emit.emitRaw(Config.TEXT_SECTION);
		this.emit.emitRaw(".globl " + MAIN);
		this.emit.emitLabel(MAIN);

		this.emit.emit("enter", "$0", "$0");
		this.emit.emit("and", -16, STACK_REG);

		ClassDecl mainClass = null;

		// Create Instance of Class Main
		Register locationOfMainInstance = this.rm.getRegister();
		for (ClassDecl classDecl : astRoots) {
			if (classDecl.name.equals("Main")) {
				mainClass = classDecl;

				// for (VarDecl field : mainClass.fields()) {
				this.emit.emit("subl", 8, RegisterManager.STACK_REG);

				int numberOfFields = mainClass.fields().size();// + 1; //Plus
																// Pointer to
																// the VTable
				this.emit.emit("movl", "$" + numberOfFields, "0(" + RegisterManager.STACK_REG + ")");
				// TODO not always 4
				this.emit.emit("movl", "$4", "4(" + RegisterManager.STACK_REG + ")");
				this.emit.emit("call", Config.CALLOC);
				this.emit.emit("addl", 8, RegisterManager.STACK_REG);

				this.emit.emit("movl", Register.EAX, locationOfMainInstance);

			}
		}

		// Call Main method
		VTable vTable = AstCodeGenerator.classTables.get("Main");
		Register locationOfMainVtable = this.rm.getRegister();
		// Load adress of CalledFnc
		this.emit.emit("leal", "Main", locationOfMainVtable);
		// Add Offset of method
		this.emit.emit("movl", locationOfMainVtable, "0(" + locationOfMainInstance + ")"); // Add
																							// Pointer
																							// in
																							// the
																							// isntance
																							// to
																							// the
																							// vtable

		this.emit.emit("addl", "$-4", this.rm.STACK_REG);
		//this.currentStackPointerOffset -= 4;
		this.emit.emitMove(locationOfMainInstance, "0(" + this.rm.STACK_REG.repr + ")");
		//System.out.println(">>>>StackPointer is now at: " + this.currentStackPointerOffset);
		this.rm.releaseRegister(locationOfMainInstance);

		int offSet = vTable.getMethodOffset("main");

		this.emit.emit("addl", "$" + offSet, locationOfMainVtable);
		this.emit.emit("movl", "0(" + locationOfMainVtable + ")", locationOfMainVtable);
		this.emit.emit("call", "*" + locationOfMainVtable);
		this.rm.releaseRegister(locationOfMainVtable);

		this.emit.emit("movl", "$0", "0(%esp)"); // Error 144 if not - hou?
		this.emit.emit("call", Config.EXIT);

		for (ClassDecl classDecl : astRoots) {
			sg.gen(classDecl, new VarLocation(this));
		}
		printTables();
	}

	protected void initMethodData() {
		{
			rm.initRegisters();
		}
	}

	protected void emitDataSection(List<? extends ClassDecl> astRoots) {
		
	
		fillTables(astRoots);
		

		this.emit.emitRaw(Config.DATA_INT_SECTION);

		for (ClassDecl ast : astRoots) {
			emit.emitLabel(ast.name);
			for (MethodDecl mths : ast.methods()) {
				String label = Config.DOT_INT + " " + ast.name + "." + mths.name;
				emit.emitRaw(label);
			}
		}

	}

	protected void fillTables(List<? extends ClassDecl> astRoots) {
		
		System.out.println(astRoots);
		for (ClassDecl ast : astRoots) {

			if (ast.superClass.equals("Object")) {
				VTable currT = new VTable(ast.name);
				currT.superClass = ast.superClass;
				classTables.put(ast.name, currT);

				int offSet = 0;
				for (MethodDecl mths : ast.methods()) {
					currT.addMethod(mths.name, offSet);
					offSet++;
				}
				offSet = 0;
				for (VarDecl field : ast.fields()) {
					currT.addField(field.name, offSet);
					offSet++;
				}
			}
		}
		
		System.out.println("here1");
		printTables();
		
		while(classTables.size() != astRoots.size()){

			for (ClassDecl ast : astRoots) {
				if (classTables.containsKey(ast.superClass)) {
					System.out.println("here2");
					VTable currT = new VTable(ast.name);
					currT.superClass = ast.superClass;
					classTables.put(ast.name, currT);
					
					
					int offSet = 0;
					for(String meth : classTables.get(ast.superClass).getMethods()){
						currT.addMethod(meth, classTables.get(ast.superClass).getMethodOffset(meth));
					}
					for (MethodDecl mths : ast.methods()) {
						if(currT.getMethods().contains(mths.name)){
							currT.addMethod(mths.name, currT.getMethodOffset(mths.name));
						}else{
							currT.addMethod(mths.name, offSet);
							offSet++;
						}
					}
					for(String field : classTables.get(ast.superClass).getFields()){
						currT.addField(field, classTables.get(ast.superClass).getFieldOffset(field));
					}
					for (VarDecl field : ast.fields()) {
						if(currT.getFields().contains(field.name)){
							currT.addField(field.name, currT.getFieldOffset(field.name));
						}else{
							currT.addField(field.name, offSet);
							offSet++;
						}
					}
				}
			}
		}
		printTables();
	}

	protected void emitMethodSuffix(boolean returnNull) {
		if (returnNull)
			emit.emit("movl", "$0", Register.EAX);
		emit.emitRaw("leave");
		emit.emitRaw("ret");
	}

	public void printTables() {
		System.out.println("////////////////////////////////");
		System.out.println("VirtualTables:");
		for (String vt : classTables.keySet()) {
			System.out.println(vt);
			System.out.println("=======");
			System.out.println(classTables.get(vt));
		}
		System.out.println("////////////////////////////////");
		System.out.println("ObjectTables:");

	}

}