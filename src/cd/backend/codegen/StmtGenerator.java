package cd.backend.codegen;

import cd.Config;
import cd.ToDoException;
import cd.backend.codegen.RegisterManager.Register;
import cd.ir.Ast;
import cd.ir.Ast.Assign;
import cd.ir.Ast.BuiltInWrite;
import cd.ir.Ast.BuiltInWriteln;
import cd.ir.Ast.IfElse;
import cd.ir.Ast.MethodCall;
import cd.ir.Ast.MethodDecl;
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
		//TODO
		System.out.println("==MethodCall");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register methodDecl(MethodDecl ast, Void arg) {
		System.out.println("==MethodDecl");
		{
			cg.rm.initRegisters(); //TODO init every function call?
			cg.emit.emitLabel("_"+ast.name);
			
			cg.emit.emit("pushl",RegisterManager.BASE_REG);
			cg.emit.emitMove(RegisterManager.STACK_REG, RegisterManager.BASE_REG);
			
			visit(ast.body(), arg);
			
			//cg.emit.emitMove(RegisterManager.BASE_REG, RegisterManager.STACK_REG);
			cg.emit.emitMove("$0", "%eax");
			//cg.emit.emit("popl",RegisterManager.BASE_REG);
			
			cg.emit.emitRaw("leave");
			cg.emit.emitRaw("ret");

			
			return null;
		}
	}

	@Override
	public Register ifElse(IfElse ast, Void arg) {
		System.out.println("==ifEles");
		//TODO
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register whileLoop(WhileLoop ast, Void arg) {

		System.out.println("==whileLoop");
		//TODO
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
			
			Register leftS = cg.eg.visit(ast.left(),arg);
			Register rightS = cg.eg.visit(ast.right(),arg);
			
			System.out.println("assign");
			cg.emit.emitStore(rightS,0,leftS);

			
			cg.rm.releaseRegister(leftS);
			cg.rm.releaseRegister(rightS);
			return null;
			
			//throw new ToDoException();
		}
	}

	@Override
	public Register builtInWrite(BuiltInWrite ast, Void arg) {
		System.out.println("==write");
		//TODO
		Register argument = visit(ast.arg(),arg);
		
		//cg.emit.emitMove(argument, RegisterManager.Register.EAX);
		//cg.emit.emit("pushl", RegisterManager.Register.EAX);
		
		cg.emit.emit("pushl", argument);
		cg.emit.emit("pushl",Config.DOT_INT);
		
		cg.emit.emit("call", Config.PRINTF);
		
		//{
		//	throw new ToDoException();
		//}
		return null;
	}

	@Override
	public Register builtInWriteln(BuiltInWriteln ast, Void arg) {
		//TODO
		System.out.println("==writeln");
		
		{
			throw new ToDoException();
		}
	}

}
