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
		//TODO: Not tested
		System.out.println("===BinOP");
		Register regLeft = visit(ast.left(),arg);
		Register regRight = visit(ast.right(),arg);
		
		
		cg.emit.emit("pushl", regLeft);
		cg.emit.emit("pushl", regRight);
		
		String rightHandSite = cg.emit.registerOffset(0, Register.ESP);
		cg.emit.emitLoad(4, Register.ESP, regLeft);
		
		switch(ast.operator){
		case B_PLUS:
			cg.emit.emit("addl", rightHandSite, regLeft);
			break;
			
		case B_MINUS:
			cg.emit.emit("subl",rightHandSite, regLeft);
			break;
			
		case B_TIMES:
			cg.emit.emit("imull",rightHandSite, regLeft);
			break;
			
		case B_DIV:
			cg.emit.emit("cmpl", cg.emit.constant(0), rightHandSite);
			cg.emit.emit("pushl", Register.EAX);
			cg.emit.emitMove(regLeft, Register.EAX);
			cg.emit.emit("idivl", rightHandSite);
			cg.emit.emitMove(Register.EAX, regLeft);
			cg.emit.emit("popl", Register.EAX);
			break;
	
		default:
			break;
		}
		
		return regLeft;
	}

	@Override
	public Register booleanConst(BooleanConst ast, Void arg) {
		System.out.println("==boolConst");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register builtInRead(BuiltInRead ast, Void arg) {
		System.out.println("==read");
		//TODO
		cg.emit.emit("pushl", Register.ESP);
		cg.emit.emit("call", Config.SCANF);
		
		Register reg = cg.rm.getRegister();
		cg.emit.emitLoad(0, Register.ESP, reg);
		return reg;
	}

	@Override
	public Register cast(Cast ast, Void arg) {
		System.out.println("==cast");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register index(Index ast, Void arg) {
		System.out.println("==index");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register intConst(IntConst ast, Void arg) {

		System.out.println("===intConst");
		Register regInt = cg.rm.getRegister();
		cg.emit.emitMove(AssemblyEmitter.constant(ast.value),regInt);
		return regInt;
	}

	@Override
	public Register field(Field ast, Void arg) {
		System.out.println("==field");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register newArray(NewArray ast, Void arg) {
		System.out.println("==newArray");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register newObject(NewObject ast, Void arg) {
		System.out.println("==newObject");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register nullConst(NullConst ast, Void arg) {
		System.out.println("==nullConst");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register thisRef(ThisRef ast, Void arg) {
		System.out.println("==thisRef");
		{
			throw new RuntimeException("Not required");
		}
	}

	@Override
	public Register unaryOp(UnaryOp ast, Void arg) {
		System.out.println("==unaryOP");
		//TODO
		Register reg = visit(ast.arg(), arg);
		
		switch(ast.operator){
		case U_PLUS:
			//Passiert nichts
			break;
		case U_MINUS:
			cg.emit.emit("negl", reg);
			break;
		default:
			break;
		
		}
		
		return reg;
		
		
	}
	
	@Override
	public Register var(Var ast, Void arg) {
		System.out.println("==var");
		//TODO
		//Panuya: keine Ahnung wie es geht
		
		
		{
			throw new ToDoException();
		}
	}

}
