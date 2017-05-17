package cd.backend.codegen;

import static cd.Config.MAIN;
import static cd.backend.codegen.AssemblyEmitter.constant;
import static cd.backend.codegen.RegisterManager.STACK_REG;

import java.util.List;

import cd.Config;
import cd.ToDoException;
import cd.backend.codegen.RegisterManager.Register;
import cd.ir.Ast;
import cd.ir.Ast.Assign;
import cd.ir.Ast.BuiltInWrite;
import cd.ir.Ast.BuiltInWriteln;
import cd.ir.Ast.ClassDecl;
import cd.ir.Ast.Expr;
import cd.ir.Ast.Field;
import cd.ir.Ast.IfElse;
import cd.ir.Ast.MethodCall;
import cd.ir.Ast.MethodDecl;
import cd.ir.Ast.NewObject;
import cd.ir.Ast.ReturnStmt;
import cd.ir.Ast.Var;
import cd.ir.Ast.VarDecl;
import cd.ir.Ast.WhileLoop;
import cd.ir.AstVisitor;
import cd.ir.Symbol.MethodSymbol;
import cd.ir.Symbol.VariableSymbol.Kind;
import cd.util.debug.AstOneLine;

/**
 * Generates code to process statements and declarations.
 */
class StmtGenerator extends AstVisitor<Register, VarLocation> {

	protected final AstCodeGenerator cg;

	StmtGenerator(AstCodeGenerator astCodeGenerator) {
		cg = astCodeGenerator;
	}

	public void gen(Ast ast, VarLocation varLocation) {
		visit(ast, varLocation);
	}

	@Override
	public Register visit(Ast ast, VarLocation arg) {
		try {
			cg.emit.increaseIndent("Emitting " + AstOneLine.toString(ast));
			return super.visit(ast, arg);
		} finally {
			cg.emit.decreaseIndent();
		}
	}

	@Override
	public Register methodCall(MethodCall ast, VarLocation dummy) {
		System.out.println("==MethodCall");

		Register reg = cg.eg.gen(ast.getMethodCallExpr(), dummy);
		cg.rm.releaseRegister(reg);

		return null;
	}

	public Register methodCall(MethodSymbol sym, List<Expr> allArguments) {
		System.out.println("==MethodCall - Not required");
		throw new RuntimeException("Not required");
	}

	// Emit vtable for arrays of this class:
	@Override
	public Register classDecl(ClassDecl ast, VarLocation arg) {
		System.out.println("==ClassDecl");

		if (ast.name.equals("Main")) {
			arg.currentClass = ast.name;
		} else {
			arg.currentClass = ast.name;
			cg.emit.emit("subl", 4, RegisterManager.STACK_REG);
			cg.currentStackPointerOffset -= 4;

			System.out.println(">>>>StackPointer is now at: " + cg.currentStackPointerOffset);
			// Allocate space for fields
			for (VarDecl field : ast.fields()) {
				cg.emit.emit("subl", 8, RegisterManager.STACK_REG);
				cg.emit.emit("movl", "$1", "0(" + RegisterManager.STACK_REG + ")");
				// TODO not always 4
				cg.emit.emit("movl", "$4", "4(" + RegisterManager.STACK_REG + ")");

				cg.emit.emit("call", Config.CALLOC);
				cg.emit.emit("addl", 8, RegisterManager.STACK_REG);

				Register reg = cg.rm.getRegister();
				cg.emit.emit("movl", Register.EAX, reg);
				cg.emit.emitMove(reg, cg.currentStackPointerOffset + "(" + cg.rm.BASE_REG.repr + ")");
				cg.classTables.get(arg.currentClass).addField(field.name, cg.currentStackPointerOffset);
				cg.emit.emit("addl", "$-4", cg.rm.STACK_REG);
				cg.currentStackPointerOffset -= 4;

				System.out.println(">>>>StackPointer is now at: " + cg.currentStackPointerOffset);
			}
		}

		visitChildren(ast, arg);
		return null;
	}

	@Override
	public Register methodDecl(MethodDecl ast, VarLocation argOld) {
		System.out.println("==MethodDecl");

		VarLocation arg = new VarLocation(cg);
		arg.currentClass = argOld.currentClass;
		arg.numberOfParameters = ast.argumentNames.size();
		System.out.println(arg);

		// if (ast.name.equals("main")) {
		// cg.emit.emitLabel(MAIN);
		// }

		cg.emit.emitLabel(arg.currentClass + "." + ast.name);

		cg.emit.emit("enter", "$0", "$0");
		// AstCodeGenerator.classTables.get(arg.currentClass).adjustOffSet(24);

		// cg.emit.emit("and", -16, STACK_REG); // What is the use of that?

		int currentOffset = 8;

		for (String argName : ast.argumentNames) {
			arg.putParameters(argName, currentOffset);
			currentOffset += 4;
		}

		gen(ast.body(), arg);

		if (!arg.currentClass.equals("Main") || !ast.name.equals("main")) {
			// AstCodeGenerator.classTables.get(arg.currentClass).adjustOffSet(-24);
		}

		System.out.println(arg);

		cg.emitMethodSuffix(true);

		return null;

	}

	@Override
	public Register ifElse(IfElse ast, VarLocation arg) {
		System.out.println("==IfElse");
		{

			String labelThen = cg.emit.uniqueLabel();
			String labelOtherwise = cg.emit.uniqueLabel();
			String doneLabel = cg.emit.uniqueLabel();
			// TODO:
			Register conditionReg = cg.eg.gen(ast.condition(), arg);

			cg.emit.emit("cmpl", constant(0), conditionReg);

			// System.out.println("Here");
			// cg.emit.emitLabel(labelThen);
			cg.emit.emit("je", labelThen);
			visit(ast.then(), arg);
			cg.emit.emit("jmp", labelOtherwise);
			cg.emit.emitLabel(labelThen);
			//
			// visit(ast.then(), arg);
			// cg.emit.emit("jmp", doneLabel);
			//
			visit(ast.otherwise(), arg);
			// cg.emit.emit("jmp", doneLabel);
			cg.emit.emitLabel(labelOtherwise);

			visit(ast.otherwise(), arg);

			// if(ast.otherwise() == null){
			//
			//
			// //Then part
			// visit(ast.then(),arg);
			//
			// }else{
			//
			// }

			return null;
		}
	}

	@Override
	public Register whileLoop(WhileLoop ast, VarLocation arg) {
		System.out.println("==WhileLoop");
		{
			throw new ToDoException();
		}
	}

	@Override
	public Register assign(Assign ast, VarLocation arg) {
		System.out.println("==Assign");
		{
			// if (!(ast.left() instanceof Var))
			// throw new RuntimeException("LHS must be var in HW1");
			// Var var = (Var) ast.left();
			
			
			arg.calculateValue = false;
			Register lhsReg = cg.eg.gen(ast.left(), arg);
			arg.calculateValue = true;
			Register rhsReg = cg.eg.gen(ast.right(), arg);
			
			cg.emit.emit("movl", rhsReg, "0("+lhsReg+")");
			

//			if (ast.left() instanceof Var) {
//				Var var = (Var) ast.left();
//
//				if (ast.right() instanceof NewObject) {
//					VTable vt = AstCodeGenerator.classTables.get(ast.left().type.name).copy();
//					AstCodeGenerator.objectTables.put(var.name, new VTable(vt.className));
//				}
//
//				if (var.sym.kind == Kind.LOCAL) {
//					lhsReg = cg.eg.gen(ast.left(), arg);
//
//					cg.emit.emit("movl", rhsReg, lhsReg);
//					cg.emit.emitMove(lhsReg, arg.getVariableLocation(var.name));
//
//				}

//				if (var.sym.kind == Kind.FIELD) {
//
//					int offSet = 8 + arg.numberOfParameters * 4;
//					cg.emit.emit("movl", offSet + "(" + cg.rm.BASE_REG + ")", lhsReg);
//
//					// cg.emit.emit("movl", "0(" + lhsReg + ")", lhsReg);
//					cg.emit.emit("movl", rhsReg, "0(" + lhsReg + ")");
//
//					// cg.emit.emitMove(rhsReg, "0(" + lhsReg + ")");
//					// cg.emit.emitMove();
//				}
//			} else if (ast.left() instanceof Field) {
//				lhsReg = cg.eg.gen(ast.left(), arg);
//
//			} else {
//				throw new RuntimeException("LHS must be var in HW1");
//			}
			cg.rm.releaseRegister(rhsReg);
			cg.rm.releaseRegister(lhsReg);

			return null;
		}
	}

	@Override
	public Register builtInWrite(BuiltInWrite ast, VarLocation arg) {
		System.out.println("==Write");
		{
			Register reg = cg.eg.gen(ast.arg(), arg);
			cg.emit.emit("sub", constant(16), STACK_REG);
			cg.emit.emitStore(reg, 4, STACK_REG);
			cg.emit.emitStore("$STR_D", 0, STACK_REG);
			cg.emit.emit("call", Config.PRINTF);
			cg.emit.emit("add", constant(16), STACK_REG);
			cg.rm.releaseRegister(reg);
			return null;
		}
	}

	@Override
	public Register builtInWriteln(BuiltInWriteln ast, VarLocation arg) {
		System.out.println("==Writeln");
		{
			cg.emit.emit("sub", constant(16), STACK_REG);
			cg.emit.emitStore("$STR_NL", 0, STACK_REG);
			cg.emit.emit("call", Config.PRINTF);
			cg.emit.emit("add", constant(16), STACK_REG);
			return null;
		}
	}

	@Override
	public Register returnStmt(ReturnStmt ast, VarLocation arg) {
		System.out.println("==ReturnStmt");
		{
			if (ast.arg() == null) {
				cg.emitMethodSuffix(true);
			} else {

				Register reg = cg.eg.gen(ast.arg(), arg);
				// TODO: Panuya: Need to find out where I should put the reg -
				// Into the EAX register
				cg.emit.emitMove(reg, Register.EAX);
				cg.emitMethodSuffix(false);
				cg.rm.releaseRegister(reg);
			}

			return null;
		}
	}

}
