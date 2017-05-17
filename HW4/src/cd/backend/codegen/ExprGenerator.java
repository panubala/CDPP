package cd.backend.codegen;

import static cd.Config.SCANF;
import static cd.backend.codegen.AssemblyEmitter.constant;
import static cd.backend.codegen.RegisterManager.STACK_REG;

import java.util.Arrays;
import java.util.List;

import cd.Config;
import cd.ToDoException;
import cd.backend.ExitCode;
import cd.backend.codegen.RegisterManager.Register;
import cd.ir.Ast;
import cd.ir.Ast.BinaryOp;
import cd.ir.Ast.BooleanConst;
import cd.ir.Ast.BuiltInRead;
import cd.ir.Ast.Cast;
import cd.ir.Ast.Expr;
import cd.ir.Ast.Field;
import cd.ir.Ast.Index;
import cd.ir.Ast.IntConst;
import cd.ir.Ast.MethodCallExpr;
import cd.ir.Ast.NewArray;
import cd.ir.Ast.NewObject;
import cd.ir.Ast.NullConst;
import cd.ir.Ast.ThisRef;
import cd.ir.Ast.UnaryOp;
import cd.ir.Ast.Var;
import cd.ir.ExprVisitor;
import cd.ir.Symbol.VariableSymbol.Kind;
import cd.util.debug.AstOneLine;

/**
 * Generates code to evaluate expressions. After emitting the code, returns a
 * String which indicates the register where the result can be found.
 */
class ExprGenerator extends ExprVisitor<Register, VarLocation> {
	protected final AstCodeGenerator cg;

	ExprGenerator(AstCodeGenerator astCodeGenerator) {
		cg = astCodeGenerator;
	}

	public Register gen(Expr ast, VarLocation arg) {
		return visit(ast, arg);
	}

	@Override
	public Register visit(Expr ast, VarLocation arg) {
		try {
			cg.emit.increaseIndent("Emitting " + AstOneLine.toString(ast));
			return super.visit(ast, arg);
		} finally {
			cg.emit.decreaseIndent();
		}

	}

	@Override
	public Register binaryOp(BinaryOp ast, VarLocation arg) {
		System.out.println("==BinaryOp");
		{
			// Simplistic HW1 implementation that does
			// not care if it runs out of registers, and
			// supports only a limited range of operations:

			int leftRN = cg.rnv.calc(ast.left());
			int rightRN = cg.rnv.calc(ast.right());

			String op = "";

			Register leftReg, rightReg;
			if (leftRN > rightRN) {
				leftReg = gen(ast.left(), arg);
				rightReg = gen(ast.right(), arg);
			} else {
				rightReg = gen(ast.right(), arg);
				leftReg = gen(ast.left(), arg);
			}

			cg.debug("Binary Op: %s (%s,%s)", ast, leftReg, rightReg);

			switch (ast.operator) {
			case B_TIMES:
				cg.emit.emit("imul", rightReg, leftReg);
				break;
			case B_PLUS:
				cg.emit.emit("add", rightReg, leftReg);
				break;
			case B_MINUS:
				cg.emit.emit("sub", rightReg, leftReg);
				break;
			case B_DIV:
				// Save EAX, EBX, and EDX to the stack if they are not used
				// in this subtree (but are used elsewhere). We will be
				// changing them.
				List<Register> dontBother = Arrays.asList(rightReg, leftReg);
				Register[] affected = { Register.EAX, Register.EBX, Register.EDX };

				for (Register s : affected)
					if (!dontBother.contains(s) && cg.rm.isInUse(s))
						cg.emit.emit("pushl", s);

				// Move the LHS (numerator) into eax
				// Move the RHS (denominator) into ebx
				cg.emit.emit("pushl", rightReg);
				cg.emit.emit("pushl", leftReg);
				cg.emit.emit("popl", Register.EAX);
				cg.emit.emit("popl", "%ebx");
				cg.emit.emitRaw("cltd"); // sign-extend %eax into %edx
				cg.emit.emit("idivl", "%ebx"); // division, result into edx:eax

				// Move the result into the LHS, and pop off anything we saved
				cg.emit.emit("movl", Register.EAX, leftReg);
				for (int i = affected.length - 1; i >= 0; i--) {
					Register s = affected[i];
					if (!dontBother.contains(s) && cg.rm.isInUse(s))
						cg.emit.emit("popl", s);
				}
				break;
			case B_AND:
				cg.emit.emit("and", leftReg, rightReg);
				break;

			case B_OR:
				cg.emit.emit("or", leftReg, rightReg);
				break;

			case B_EQUAL:
				op = "je";

			case B_NOT_EQUAL:
				op = "jne";

			case B_LESS_THAN:
				op = "jl";

			case B_LESS_OR_EQUAL:
				op = "jle";

			case B_GREATER_THAN:
				op = "jg";

			case B_GREATER_OR_EQUAL:
				op = "jge";

				String trueLabel = cg.emit.uniqueLabel();
				String falseLabel = cg.emit.uniqueLabel();

				cg.emit.emit("cmp", rightReg, leftReg);
				cg.emit.emit(op, trueLabel);
				cg.emit.emitMove(constant(0), leftReg);
				cg.emit.emit("jmp", falseLabel);
				cg.emit.emitLabel(trueLabel);
				cg.emit.emitMove(constant(1), leftReg);
				cg.emit.emitLabel(falseLabel);
				break;
			
			}

			cg.rm.releaseRegister(rightReg);

			return leftReg;
		}
	}

	@Override
	public Register booleanConst(BooleanConst ast, VarLocation arg) {
		System.out.println("==BooleanConst");
		{
			Register reg = cg.rm.getRegister();

			String bool = (ast.value == true) ? constant(1) : constant(0);

			cg.emit.emitMove(bool, reg);

			return reg;

		}
	}

	@Override
	public Register builtInRead(BuiltInRead ast, VarLocation arg) {
		System.out.println("==Read");
		{
			Register reg = cg.rm.getRegister();
			cg.emit.emit("sub", constant(16), STACK_REG);
			cg.emit.emit("leal", AssemblyEmitter.registerOffset(8, STACK_REG), reg);
			cg.emit.emitStore(reg, 4, STACK_REG);
			cg.emit.emitStore("$STR_D", 0, STACK_REG);
			cg.emit.emit("call", SCANF);
			cg.emit.emitLoad(8, STACK_REG, reg);
			cg.emit.emit("add", constant(16), STACK_REG);
			return reg;
		}
	}

	@Override
	public Register cast(Cast ast, VarLocation arg) {
		System.out.println("==Cast");
		{
			// TODO
			System.out.println(ast.typeName);

			System.out.println(ast.arg());
			
			//ast.arg muss von ast.typeName erben
			
			String parent = ast.typeName;
			String child = ast.arg().type.name;
			
			System.out.println(parent);

			System.out.println(child);
			boolean found = false;
			while(!found){
				System.out.println(child);
				if(!child.equals("Object")){
					found = child.equals(parent);
					child = AstCodeGenerator.classTables.get(child).superClass;
				} else{
					System.out.println("Error Downcast");
					throw new ToDoException();
				}
			}
			
			VTable classTable = AstCodeGenerator.classTables.get(ast.arg().type.name);

			int noF = classTable.numberOfField();

			// Add arguments for calloc(#items, size_of_1_item)
			cg.emit.emit("subl", 16, RegisterManager.STACK_REG);
			cg.emit.emit("movl", "$" + noF, "0(" + RegisterManager.STACK_REG + ")");
			cg.emit.emit("movl", "$4", "4(" + RegisterManager.STACK_REG + ")");

			cg.emit.emit("call", Config.CALLOC);

			cg.emit.emit("addl", 16, RegisterManager.STACK_REG);

			Register reg = cg.rm.getRegister();
			cg.emit.emit("movl", Register.EAX, reg);

			return reg;

		}
	}

	@Override
	public Register index(Index ast, VarLocation arg) {
		System.out.println("==index");

		boolean temp = arg.calculateValue;

		arg.calculateValue = false;
		Register locationOfObject = cg.eg.gen(ast.left(), arg);

		arg.calculateValue = true;
		Register offSet = cg.eg.gen(ast.right(), arg);

		cg.emit.emit("addl", "$1", offSet); // Add one because first entry is
											// the length of array

		cg.emit.emit("addl", offSet, locationOfObject);

		cg.rm.releaseRegister(offSet);

		if (temp) { // return Value
			cg.emit.emit("movl", "0(" + locationOfObject + ")", locationOfObject);
		}
		return locationOfObject;
	}

	@Override
	public Register intConst(IntConst ast, VarLocation arg) {
		System.out.println("==IntConst");
		{
			Register reg = cg.rm.getRegister();
			cg.emit.emit("movl", "$" + ast.value, reg);
			return reg;
		}
	}

	@Override
	public Register field(Field ast, VarLocation arg) {
		System.out.println("==Field");

		System.out.println(ast.arg().type.name);

		boolean temp = arg.calculateValue;

		arg.calculateValue = false;
		Register locationOfInstance = cg.eg.gen(ast.arg(), arg);
		arg.calculateValue = temp;

		int fieldOffset = AstCodeGenerator.classTables.get(ast.arg().type.name).getFieldOffset(ast.fieldName);

		Register returnReg = cg.rm.getRegister();

		if (arg.calculateValue) {
			cg.emit.emit("movl", fieldOffset + "(" + locationOfInstance + ")", returnReg);
		} else {
			cg.emit.emit("leal", fieldOffset + "(" + locationOfInstance + ")", returnReg);
		}
		cg.rm.releaseRegister(locationOfInstance);

		return returnReg;
	}

	@Override
	public Register newArray(NewArray ast, VarLocation arg) {
		System.out.println("==NewArray");

		Register numberOfEl = cg.eg.gen(ast.arg(), arg);

		// TODO test if value pos

		cg.emit.emit("addl", "$1", numberOfEl); // First Element stores length
												// of Array

		cg.emit.emit("subl", 16, RegisterManager.STACK_REG);
		cg.emit.emit("movl", numberOfEl, "0(" + RegisterManager.STACK_REG + ")");
		cg.emit.emit("movl", "$4", "4(" + RegisterManager.STACK_REG + ")");

		cg.emit.emit("call", Config.CALLOC);

		cg.emit.emit("addl", 16, RegisterManager.STACK_REG);

		Register reg = cg.rm.getRegister();
		cg.emit.emit("movl", Register.EAX, reg);

		return reg;
	}

	@Override
	public Register newObject(NewObject ast, VarLocation arg) {
		System.out.println("==NewObject");

		VTable classTable = AstCodeGenerator.classTables.get(ast.typeName);

		int noF = classTable.numberOfField();

		// Add arguments for calloc(#items, size_of_1_item)
		cg.emit.emit("subl", 16, RegisterManager.STACK_REG);
		cg.emit.emit("movl", "$" + noF, "0(" + RegisterManager.STACK_REG + ")");
		cg.emit.emit("movl", "$4", "4(" + RegisterManager.STACK_REG + ")");

		cg.emit.emit("call", Config.CALLOC);

		cg.emit.emit("addl", 16, RegisterManager.STACK_REG);

		Register reg = cg.rm.getRegister();
		cg.emit.emit("movl", Register.EAX, reg);

		return reg;

	}

	@Override
	public Register nullConst(NullConst ast, VarLocation varLoc) {
		System.out.println("==NullConst");
		{
			Register reg = cg.rm.getRegister();
			cg.emit.emitMove(constant(0), reg);
			return reg;
		}
	}

	@Override
	public Register thisRef(ThisRef ast, VarLocation arg) {
		System.out.println("==ThisRef");


		Register locationOfThisInstance = cg.rm.getRegister();
		int offSet = 8 + arg.numberOfParameters * 4;
		cg.emit.emit("movl", offSet + "(" + RegisterManager.BASE_REG + ")", locationOfThisInstance);
		return locationOfThisInstance;

	}

	@Override
	public Register methodCall(MethodCallExpr ast, VarLocation varLoc) {
		System.out.println("==Expr-MethodCall");
		List<Expr> args = ast.argumentsWithoutReceiver();



		// check nullPointer
		if (ast.receiver() instanceof Ast.Var) {
			Var v = (Ast.Var) ast.receiver();
			System.out.println(v.name);
			if (!AstCodeGenerator.objectTables.containsKey(v.name)) {
				System.out.println("NULLPOINTER_EXCEPTION");

				cg.emit.emit("subl", "4", cg.rm.STACK_REG);
				cg.emit.emit("movl", "$4", "0(" + cg.rm.STACK_REG + ")"); // Exit
																			// Code
																			// 4:
																			// NullPointerException
				cg.emit.emit("call", Config.EXIT);
				cg.emit.emit("addl", "4", cg.rm.STACK_REG);
			}
		}


		Register locationOfClassInstance = cg.eg.gen(ast.receiver(), varLoc); // Adress
																				// of
																				// instance


		// Load adress of CalledFnc

		String calledClass = ast.receiver().type.name;
		VTable vTable = AstCodeGenerator.classTables.get(calledClass);

		Register locationOfClassVTable = cg.rm.getRegister();
		cg.emit.emit("leal", calledClass, locationOfClassVTable);

		// Add Offset of method
		int offSet = vTable.getMethodOffset(ast.methodName);


		cg.emit.emit("addl", "$-4", RegisterManager.STACK_REG);
		cg.currentStackPointerOffset -= 4;
		cg.emit.emitMove(locationOfClassInstance, "0(" + RegisterManager.STACK_REG.repr + ")");
		System.out.println(">>>>StackPointer is now at: " + cg.currentStackPointerOffset);
		cg.rm.releaseRegister(locationOfClassInstance);

		// Make space for arguments
		cg.emit.emit("subl", args.size() * 4, cg.rm.STACK_REG); // TODO 4?
		cg.currentStackPointerOffset -= args.size() * 4;

		System.out.println(">>>>StackPointer is now at: " + cg.currentStackPointerOffset);

		// push arguments
		int offset = 0;
		for (Expr argument : args) {
			// TODO add emitMove(reg, offset, baseP) -> emitStore
			String dest = offset + "(" + cg.rm.STACK_REG.repr + ")";
			Register reg = cg.eg.gen(argument, varLoc);
			cg.emit.emitMove(reg, dest);
			cg.rm.releaseRegister(reg);
			offset += 4;
		}

		cg.emit.emit("addl", "$" + offSet, locationOfClassVTable);


		cg.emit.emit("movl", "0(" + locationOfClassVTable + ")", locationOfClassVTable);
		cg.emit.emit("call", "*" + locationOfClassVTable);

		cg.rm.releaseRegister(locationOfClassVTable);
		System.out.println("----------------------------------------");

		// Return value
		AstCodeGenerator.classTables.get(varLoc.currentClass).adjustOffSet(-24);
		Register retValue = cg.rm.getRegister();

		cg.emit.emit("movl", Register.EAX, retValue);
		// cg.rm.releaseRegister(Register.EAX);

		return retValue;
	}

	@Override
	public Register unaryOp(UnaryOp ast, VarLocation arg) {
		System.out.println("==UnaryOp");
		{
			Register argReg = gen(ast.arg(), arg);
			switch (ast.operator) {
			case U_PLUS:
				break;

			case U_MINUS:
				cg.emit.emit("negl", argReg);
				break;

			case U_BOOL_NOT:
				cg.emit.emit("negl", argReg);
				cg.emit.emit("incl", argReg);
				break;
			}

			return argReg;
		}
	}

	@Override
	public Register var(Var ast, VarLocation arg) {
		System.out.println("==Var " + ast.name);
		{
			Register reg = cg.rm.getRegister();

			if (ast.sym.kind == Kind.FIELD) {
				int offSet = 8 + arg.numberOfParameters * 4;
				cg.emit.emit("movl", offSet + "(" + cg.rm.BASE_REG + ")", reg);


				if (arg.calculateValue) {
					cg.emit.emit("movl", 0 + "(" + reg + ")", reg);
				}

			}
			if (ast.sym.kind == Kind.LOCAL || ast.sym.kind == Kind.PARAM) {
				String loc = arg.getVariableLocation(ast.name);

				if (arg.calculateValue) {
					cg.emit.emit("movl", loc, reg);
				} else {
					cg.emit.emit("leal", loc, reg);
				}
			}

			return reg;
		}
	}

}
