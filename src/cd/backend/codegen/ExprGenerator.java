package cd.backend.codegen;

import java.util.HashMap;

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
		// TODO: (i0 + (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7))))))) gives an error, because too many register are used
		//File: EightVariables.javali
		
		System.out.println("===BinOP");
		Register regLeft = visit(ast.left(), arg);
		Register regRight = visit(ast.right(), arg);

		cg.emit.emit("pushl", regLeft);
		cg.emit.emit("pushl", regRight);

		String rightHandSite = cg.emit.registerOffset(0, Register.ESP);
		cg.emit.emitLoad(4, Register.ESP, regLeft);

		switch (ast.operator) {
		case B_PLUS:
			cg.emit.emit("addl", rightHandSite, regLeft);
			break;

		case B_MINUS:
			cg.emit.emit("subl", rightHandSite, regLeft);
			break;

		case B_TIMES:
			cg.emit.emit("imull", rightHandSite, regLeft);
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
		// TODO
		cg.emit.emit("pushl", Register.ESP);
		cg.emit.emit("call", Config.SCANF);

		Register reg = cg.rm.getRegister();
		System.out.println(reg.repr+" occupied");
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
		System.out.println(regInt.repr+" occupied");
		cg.emit.emitMove(cg.emit.constant(ast.value), regInt);
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
		// TODO
		Register reg = visit(ast.arg(), arg);

		switch (ast.operator) {
		case U_PLUS:
			// Passiert nichts
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
		// TODO
		// Panuya: keine Ahnung wie es geht
		String name = ast.name;

		Register ret = cg.rm.getRegister();
		System.out.println(ret.repr+" occupied");

		
		if(RegisterManager.variableOffset.containsKey(name)){ //already on stack
			cg.emit.emitLoad(RegisterManager.variableOffset.get(name), RegisterManager.BASE_REG, ret);
		}		
		else{ //make space on stack 
			cg.emit.emit("addl", "$-4", RegisterManager.STACK_REG); //TODO floats Does floats need more space?
			RegisterManager.currentOffset -=4; //TODO if function call
			RegisterManager.variableOffset.put(name, RegisterManager.currentOffset);
			//cg.emit.emit("xor", ret ,ret);
		}

		// if(lookupVariable.containsKey(name))
		// return lookupVariable.get(name);
		// else{
		// Register newRet = cg.rm.getRegister();
		// lookupVariable.put(name, newRet);
		return ret;

		// {
		// throw new ToDoException();
		// }
	}
	// private static HashMap<String,Integer> lookupOffset = new
	// HashMap<String,Integer>();

}
