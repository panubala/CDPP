package cd.backend.codegen;

import static cd.Config.SCANF;
import static cd.backend.codegen.AssemblyEmitter.constant;
import static cd.backend.codegen.RegisterManager.STACK_REG;

import java.util.Arrays;
import java.util.List;

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
import cd.ir.Ast.MethodCallExpr;
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
	protected VarLocation vt;
	
	ExprGenerator(AstCodeGenerator astCodeGenerator, VarLocation virtualTable) {
		cg = astCodeGenerator;
		vt = virtualTable;
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
		System.out.println("==BinaryOp");
		{
			// Simplistic HW1 implementation that does
			// not care if it runs out of registers, and
			// supports only a limited range of operations:

			int leftRN = cg.rnv.calc(ast.left());
			int rightRN = cg.rnv.calc(ast.right());

			Register leftReg, rightReg;
			if (leftRN > rightRN) {
				leftReg = gen(ast.left());
				rightReg = gen(ast.right());
			} else {
				rightReg = gen(ast.right());
				leftReg = gen(ast.left());
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
			default:
				{
					throw new ToDoException();
				}
			}

			cg.rm.releaseRegister(rightReg);

			return leftReg;
		}
	}

	@Override
	public Register booleanConst(BooleanConst ast, Void arg) {
		System.out.println("==BooleanConst");
		{
			Register reg = cg.rm.getRegister();
			
			String bool = (ast.value == true) ? constant(1) : constant(0);
			
			cg.emit.emitMove(bool, reg);
			
			return reg;
			
		}
	}

	@Override
	public Register builtInRead(BuiltInRead ast, Void arg) {
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
	public Register cast(Cast ast, Void arg) {
		System.out.println("==Cast");
		{
			//TODO
			throw new ToDoException();
			
			
		}
	}

	@Override
	public Register index(Index ast, Void arg) {
		System.out.println("==index");
		{
			//TODO
			throw new ToDoException();
		}
	}

	@Override
	public Register intConst(IntConst ast, Void arg) {
		System.out.println("==IntConst");
		{
			Register reg = cg.rm.getRegister();
			cg.emit.emit("movl", "$" + ast.value, reg);
			return reg;
		}
	}

	@Override
	public Register field(Field ast, Void arg) {
		System.out.println("==Field");
		{
			//TODO
			throw new ToDoException();
		}
	}

	@Override
	public Register newArray(NewArray ast, Void arg) {
		System.out.println("==NewArray");
		{
			//TODO
			throw new ToDoException();
		}
	}

	@Override
	public Register newObject(NewObject ast, Void arg) {
		System.out.println("==NewObject");
		{
			//TODO
			throw new ToDoException();
		}
	}

	@Override
	public Register nullConst(NullConst ast, Void arg) {
		System.out.println("==NullConst");
		{
			//TODO
			Register reg = cg.rm.getRegister();
			cg.emit.emitMove(constant(0), reg);
			return reg;
		}
	}

	@Override
	public Register thisRef(ThisRef ast, Void arg) {
		System.out.println("==ThisRef");
		//TODO
//		{
//			throw new ToDoException();
//		}
		return cg.rm.getRegister();
	}

	@Override
	public Register methodCall(MethodCallExpr ast, Void arg) {
		System.out.println("==Expr-MethodCall");		
		List<Expr> args = ast.argumentsWithoutReceiver();
		//Make space for arguments
		cg.emit.emit("subl", args.size()*4, cg.rm.STACK_REG); //TODO 4?
		cg.currentStackPointerOffset -= args.size()*4;
		
		int offset = 0;
		for(Expr argument : args){
			//TODO add emitMove(reg, offset, baseP)
			String dest = offset + "(" + cg.rm.STACK_REG.repr + ")";
			Register reg = cg.eg.gen(argument);
			cg.emit.emitMove(reg, dest);
			cg.rm.releaseRegister(reg);
			offset +=4;
		}
		//push returnAdress onto the stack
		//cg.emit.emit("pushl", cg.rm.STACK_REG.repr);
		
		//TODO receiver
		VTable vTable = AstCodeGenerator.vTables.get("Main"); //TODO Main harcoded
		
		Register reg = cg.rm.getRegister();
		
		//Load adress of MainFnc
		cg.emit.emit("leal", "Main", reg);
		
		//Add Offset of method
		int offSet = vTable.getMethodOffset(ast.methodName);
		
		cg.emit.emit("addl", "$"+offSet, reg);
		
		cg.emit.emit("movl", "0(" + reg + ")", reg);
		cg.emit.emit("call", "*"+reg);
		
		cg.rm.releaseRegister(reg);
		System.out.println("----------------------------------------");
		
		//Return value
		
		Register retValue = cg.rm.getRegister();
		
		cg.emit.emit("movl", Register.EAX, retValue);
		//cg.rm.releaseRegister(Register.EAX);
		
		return retValue;
	}

	@Override
	public Register unaryOp(UnaryOp ast, Void arg) {
		System.out.println("==UnaryOp");
		{
			Register argReg = gen(ast.arg());
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
	public Register var(Var ast, Void arg) {
		System.out.println("==Var");
		{
			Register reg = cg.rm.getRegister();

			cg.emit.emit("movl",vt.getVariableLocation(ast.name), reg);
			return reg;
		}
	}

}
