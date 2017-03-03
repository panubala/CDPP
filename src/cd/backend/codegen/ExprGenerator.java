package cd.backend.codegen;

import cd.Config;
import cd.ToDoException;
import cd.backend.codegen.RegisterManager.Register;
import cd.ir.Ast.BinaryOp;
import cd.ir.Ast.BooleanConst;
import cd.ir.Ast.BuiltInRead;
import cd.ir.Ast.Cast;
import cd.ir.Ast.Expr;
import cd.ir.Ast.Field;
import cd.ir.Ast.Index;
import cd.ir.Ast.IntConst;
import cd.ir.Ast.NewArray;
import cd.ir.Ast.NewObject;
import cd.ir.Ast.NullConst;
import cd.ir.Ast.ThisRef;
import cd.ir.Ast.UnaryOp;
import cd.ir.Ast.Var;
import cd.ir.ExprVisitor;
import cd.util.debug.AstOneLine;

import cd.backend.codegen.AssemblyEmitter;
import cd.backend.codegen.AssemblyFailedException;
//import cd.backend.codegen.AstCodeGenerator;
import cd.backend.codegen.RegisterManager;

/**
 * Generates code to evaluate expressions. After emitting the code, returns a
 * String which indicates the register where the result can be found.
 */
class ExprGenerator extends ExprVisitor<Register, Void> {
	protected final AstCodeGenerator cg;

	ExprGenerator(AstCodeGenerator astCodeGenerator) {
		cg = astCodeGenerator;
	}

	public Register gen(Expr ast) {
		return visit(ast, null);
	}

	@Override
	public Register visit(Expr ast, Void arg) {
		try {
			cg.emit.increaseIndent("Emitting " + AstOneLine.toString(ast));
			return super.visit(ast, null);
		} finally {
			cg.emit.decreaseIndent();
		}

	}

	@Override
	public Register binaryOp(BinaryOp ast, Void arg) {
		//TODO
		
		Register regLeft = visit(ast.left(),arg);
		Register regRight = visit(ast.right(),arg);
		
		cg.emit.emit("pushl", regLeft);
		cg.emit.emit("pushl", regRight);
		
		switch(ast.operator){
		case B_PLUS:
			cg.emit.emitRaw("addl");
			
		case B_MINUS:
			cg.emit.emitRaw("subl");
			
		case B_TIMES:
			cg.emit.emitRaw("imull");
			
		case B_DIV:
			//TODO
			//shit
		}
		
		return regLeft;
	}

	@Override
	public Register booleanConst(BooleanConst ast, Void arg) {
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register builtInRead(BuiltInRead ast, Void arg) {
		//TODO
		cg.emit.emit("pushl", "%esp");
		cg.emit.emit("call", Config.SCANF);
		
		{
			throw new ToDoException();
		}
	}

	@Override
	public Register cast(Cast ast, Void arg) {
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register index(Index ast, Void arg) {
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register intConst(IntConst ast, Void arg) {
		Register regInt = cg.rm.getRegister();
		cg.emit.emitMove(cg.emit.constant(ast.value),regInt);
		return regInt;
	}

	@Override
	public Register field(Field ast, Void arg) {
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register newArray(NewArray ast, Void arg) {
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register newObject(NewObject ast, Void arg) {
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register nullConst(NullConst ast, Void arg) {
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register thisRef(ThisRef ast, Void arg) {
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register unaryOp(UnaryOp ast, Void arg) {
		//TODO
		Register reg = visit(ast.arg(), arg);
		
		switch(ast.operator){
		case U_PLUS:
			//Passiert nichts
		case U_MINUS:
			cg.emit.emit("negl", reg);
		case U_BOOL_NOT:
			//müsswa ned mache
		}
		
		return reg;
		
		
	}
	
	@Override
	public Register var(Var ast, Void arg) {
		//TODO
		
//		Register regVar=
//		return regVar
		{
			throw new ToDoException();
		}
	}

}
