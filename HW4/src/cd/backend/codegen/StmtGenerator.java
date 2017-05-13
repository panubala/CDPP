package cd.backend.codegen;

import static cd.Config.MAIN;
import static cd.backend.codegen.AssemblyEmitter.constant;
import static cd.backend.codegen.RegisterManager.STACK_REG;
import static cd.backend.codegen.RegisterManager.BASE_REG;

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
import cd.ir.Ast.IfElse;
import cd.ir.Ast.MethodCall;
import cd.ir.Ast.MethodDecl;
import cd.ir.Ast.ReturnStmt;
import cd.ir.Ast.Var;
import cd.ir.Ast.VarDecl;
import cd.ir.Ast.WhileLoop;
import cd.ir.AstVisitor;
import cd.ir.Symbol.MethodSymbol;
import cd.util.debug.AstOneLine;

/**
 * Generates code to process statements and declarations.
 */
class StmtGenerator extends AstVisitor<Register, Void> {
	protected final AstCodeGenerator cg;
	protected VarLocation varLoc;

	private String currentClass;

	StmtGenerator(AstCodeGenerator astCodeGenerator, VarLocation varLocation) {
		cg = astCodeGenerator;
		varLoc = varLocation;
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
		System.out.println("==MethodCall");
		
		gen(ast.getMethodCallExpr());
		
		return null;
	}

	public Register methodCall(MethodSymbol sym, List<Expr> allArguments) {
		System.out.println("==MethodCall - Not required");
		throw new RuntimeException("Not required");
	}

	// Emit vtable for arrays of this class:
	@Override
	public Register classDecl(ClassDecl ast, Void arg) {
		System.out.println("==ClassDecl");
		{
			// if (!ast.name.equals("Main"))
			// throw new RuntimeException(
			// "Only expected one class, named 'main'");
			currentClass = ast.name;
			return visitChildren(ast, arg);
		}
	}

	@Override
	public Register methodDecl(MethodDecl ast, Void arg) {
		System.out.println("==MethodDecl");
		{

			if (ast.name.equals("main")) {
				cg.emit.emitLabel(MAIN);
			}

			cg.emit.emitLabel(currentClass + "." + ast.name);

			cg.emit.emit("enter", "$8", "$0");
			cg.emit.emit("and", -16, STACK_REG); //What is the use of that?
			
			int currentOffset = 8; //Dont know exactly why, i guess it's because retAdress is above BasePointer
			for(String argName: ast.argumentNames){			
				varLoc.putParameters(argName, currentOffset);
				currentOffset += 4;
			}
			
			gen(ast.body());
			cg.emitMethodSuffix(true);

			return null;
		}
	}

	@Override
	public Register ifElse(IfElse ast, Void arg) {
		System.out.println("==IfElse");
		{
			throw new ToDoException();
		}
	}

	@Override
	public Register whileLoop(WhileLoop ast, Void arg) {
		System.out.println("==WhileLoop");
		{
			throw new ToDoException();
		}
	}

	@Override
	public Register assign(Assign ast, Void arg) {
		System.out.println("==Assign");
		{
			// if (!(ast.left() instanceof Var))
			// throw new RuntimeException("LHS must be var in HW1");
			// Var var = (Var) ast.left();
			Register lhsReg = cg.eg.gen(ast.left());
			Register rhsReg = cg.eg.gen(ast.right());

			cg.emit.emit("movl", rhsReg, lhsReg);

			// TODO store left side correctly onto the stack
			
			if (ast.left() instanceof Var) {
				Var var = (Var) ast.left();
				cg.emit.emitMove(lhsReg, varLoc.getVariableLocation(var.name));
			} else
				throw new RuntimeException("LHS must be var in HW1");
			cg.rm.releaseRegister(rhsReg);
			cg.rm.releaseRegister(lhsReg);
			return null;
		}
	}

	@Override
	public Register builtInWrite(BuiltInWrite ast, Void arg) {
		System.out.println("==Write");
		{
			Register reg = cg.eg.gen(ast.arg());
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
	public Register builtInWriteln(BuiltInWriteln ast, Void arg) {
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
	public Register returnStmt(ReturnStmt ast, Void arg) {
		System.out.println("==ReturnStmt");
		{			
			if (ast.arg() == null){
				cg.emitMethodSuffix(true);
			}else{
				
				Register reg = cg.eg.gen(ast.arg());
				//TODO: Panuya: Need to find out where I should put the reg - Into the EAX register
				cg.emit.emitMove(reg, Register.EAX);
				cg.emitMethodSuffix(false);
				cg.rm.releaseRegister(reg);
			}
			
			
			
			return null;
		}
	}

}
