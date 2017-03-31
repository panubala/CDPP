package cd.backend.codegen;

import cd.Config;
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

		System.out.println("===BinOP");

		int numberOfNodesReft = ast.rwChildren.get(0).numberOfChildren();
		int numberOfNodesRight = ast.rwChildren.get(1).numberOfChildren();

		Register regRight;
		Register regLeft;
		if (numberOfNodesReft < numberOfNodesRight) {
			regRight = visit(ast.right(), arg);
			regLeft = visit(ast.left(), arg);
		} else {
			regLeft = visit(ast.left(), arg);
			regRight = visit(ast.right(), arg);
		}

		switch (ast.operator) {
		case B_PLUS:
			cg.emit.emit("addl", regRight, regLeft);
			break;
		case B_MINUS:
			cg.emit.emit("subl", regRight, regLeft);
			break;

		case B_TIMES:
			cg.emit.emit("imull", regRight, regLeft);
			break;

		case B_DIV:
			System.out.println("==Div");
			cg.emit.emitMove(regLeft, Register.EAX);
			cg.emit.emitRaw("cltd");
			cg.emit.emit("idivl", regRight);
			cg.emit.emitMove(Register.EAX, regLeft);
			break;

		default:
			break;
		}

		cg.rm.releaseRegister(regRight);
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
		System.out.println("==read");

		cg.emit.emitAllocation(4);

		cg.emit.emitPush(RegisterManager.STACK_REG, 4);
		cg.emit.emitPush("$.LC0", 4);

		cg.emit.emit("call", Config.SCANF);
		cg.emit.emitDeallocation(8);

		Register reg = cg.rm.getRegister();

		cg.emit.emitLoad(cg.emit.getCurrentOffset(), RegisterManager.BASE_REG, reg);
		return reg;
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
		System.out.println("===intConst");
		Register regInt = cg.rm.getRegister();
		cg.emit.emitMove(AssemblyEmitter.constant(ast.value), regInt);
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
		System.out.println("==unaryOP");
		Register reg = visit(ast.arg(), arg);

		switch (ast.operator) {
		case U_PLUS:
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

		String varName = ast.name;

		Register ret = cg.rm.getRegister();

		if (cg.emit.varOnStack(varName)) { // already on stack
			cg.emit.emitLoad(cg.emit.getVarLocation(varName), RegisterManager.BASE_REG, ret);
		} else { // make space on stack
			cg.emit.emitAllocation(4);
			cg.emit.setVarLocation(varName, cg.emit.getCurrentOffset());
		}
		return ret;
	}
}
