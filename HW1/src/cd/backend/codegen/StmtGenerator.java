package cd.backend.codegen;

import cd.Config;
import cd.backend.codegen.RegisterManager.Register;
import cd.ir.Ast;
import cd.ir.Ast.Assign;
import cd.ir.Ast.BuiltInWrite;
import cd.ir.Ast.BuiltInWriteln;
import cd.ir.Ast.IfElse;
import cd.ir.Ast.MethodCall;
import cd.ir.Ast.MethodDecl;
import cd.ir.Ast.Var;
import cd.ir.Ast.WhileLoop;
import cd.ir.AstVisitor;
import cd.util.debug.AstOneLine;

/**
 * Generates code to process statements and declarations.
 */
class StmtGenerator extends AstVisitor<Register, Void> {
	protected final AstCodeGenerator cg;

	StmtGenerator(AstCodeGenerator astCodeGenerator) {
		cg = astCodeGenerator;
	}

	public void gen(Ast ast) {
		visit(ast, null);
	}

	@Override
	public Register visit(Ast ast, Void arg) {
		try {
			cg.emit.increaseIndent("Emitting " + AstOneLine.toString(ast));
			return super.visit(ast, arg);
		} finally {
			cg.emit.decreaseIndent();
		}
	}

	@Override
	public Register methodCall(MethodCall ast, Void dummy) {
		// TODO
		System.out.println("==MethodCall");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register methodDecl(MethodDecl ast, Void arg) {
		System.out.println("==MethodDecl");
		{
			cg.rm.initRegisters(); // TODO init every function call?

			// For write(int) and read(int)
			cg.emit.emitLabel(".LC0");
			cg.emit.emitRaw(".string \"%d\"");

			// For writeln()
			cg.emit.emitLabel(".LC1");
			cg.emit.emitRaw(".string \"\\n\"");

			// Main fnc
			cg.emit.emitRaw(".globl " + Config.MAIN + "\n");
			cg.emit.emitLabel(Config.MAIN);

			cg.emit.emit("pushl", RegisterManager.BASE_REG);
			cg.emit.emitMove(RegisterManager.STACK_REG, RegisterManager.BASE_REG);

			Register r = visit(ast.body(), arg);
			cg.rm.releaseRegister(r);

			cg.emit.emitMove(RegisterManager.BASE_REG, RegisterManager.STACK_REG);
			cg.emit.emitMove("$0", "%eax");
			cg.emit.emit("popl", RegisterManager.BASE_REG);

			cg.emit.emitRaw("ret");

			return null;
		}
	}

	@Override
	public Register ifElse(IfElse ast, Void arg) {
		System.out.println("==ifEles");
		// TODO
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register whileLoop(WhileLoop ast, Void arg) {

		System.out.println("==whileLoop");
		// TODO
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register assign(Assign ast, Void arg) {
		System.out.println("==assign");
		{
			// Because we only handle very simple programs in HW1,
			// you can just emit the prologue here!

			// register with constant value
			Register valueReg = cg.eg.visit(ast.right(), arg);
			
			// register with left side (not used)
			Register varReg = cg.eg.visit(ast.left(), arg); // create new space
															// if necessar

			System.out.println("==after receiving registers (assign)");

			// get location in stack
			Ast.Var var = (Var) ast.left();
			int varLocationOffset = cg.emit.getVarLocation(var.name);

			// store new value in stack
			cg.emit.emitStore(valueReg, varLocationOffset, RegisterManager.BASE_REG);

			// Release registers
			cg.rm.releaseRegister(valueReg);
			cg.rm.releaseRegister(varReg);

			return null;
		}
	}

	@Override
	public Register builtInWrite(BuiltInWrite ast, Void arg) {
		System.out.println("==write");

		// Register with the value to print
		Register argument = cg.eg.visit(ast.arg(), arg);

		// Push argument onto the stack
		cg.emit.emitPush(argument, 4);
		cg.rm.releaseRegister(argument);

		cg.emit.emitPush("$.LC0", 4);

		cg.emit.emit("call", Config.PRINTF);

		cg.emit.emitDeallocation(8);

		return null;
	}

	@Override
	public Register builtInWriteln(BuiltInWriteln ast, Void arg) {
		System.out.println("==writeln");

		// push argument "/n" onto the stack
		cg.emit.emitPush("$.LC1", 4);

		cg.emit.emit("call", Config.PRINTF);

		cg.emit.emitDeallocation(4);

		return null;
	}

}
