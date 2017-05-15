package cd.backend.codegen;

import static cd.Config.SCANF;
import static cd.backend.codegen.AssemblyEmitter.constant;
import static cd.backend.codegen.RegisterManager.STACK_REG;

import java.util.Arrays;
import java.util.List;

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
import cd.ir.Ast.MethodCallExpr;
import cd.ir.Ast.NewArray;
import cd.ir.Ast.NewObject;
import cd.ir.Ast.NullConst;
import cd.ir.Ast.ThisRef;
import cd.ir.Ast.UnaryOp;
import cd.ir.Ast.Var;
import cd.ir.Ast;
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
			default: {
				throw new ToDoException();
			}
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
			throw new ToDoException();

		}
	}

	@Override
	public Register index(Index ast, VarLocation arg) {
		System.out.println("==index");
		{
			// TODO
			throw new ToDoException();
		}
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
		{
			// TODO
			throw new ToDoException();
		}
	}

	@Override
	public Register newArray(NewArray ast, VarLocation arg) {
		System.out.println("==NewArray");
		{
			// TODO
			throw new ToDoException();
		}
	}

	@Override
	public Register newObject(NewObject ast, VarLocation arg) {
		System.out.println("==NewObject");

		VTable classTable = AstCodeGenerator.classTables.get(ast.typeName);

		int noF = classTable.numberOfField();

		// Add arguments for calloc(#items, size_of_1_item)
		cg.emit.emit("subl", noF * 4, RegisterManager.STACK_REG);
		cg.emit.emit("movl", "$" + noF, "0(" + RegisterManager.STACK_REG + ")");
		cg.emit.emit("movl", "$4", "4(" + RegisterManager.STACK_REG + ")"); // TODO
																			// not
																			// only
																			// alwasys
																			// 4
																			// i
																			// guess,
																			// (if
																			// Objetc
																			// is
																			// in
																			// classField)

		cg.emit.emit("call", Config.CALLOC);

		cg.emit.emit("addl", noF * 4, RegisterManager.STACK_REG);

		Register reg = cg.rm.getRegister();
		cg.emit.emit("movl", Register.EAX, reg);

		return reg;

	}

	@Override
	public Register nullConst(NullConst ast, VarLocation arg) {
		System.out.println("==NullConst");
		{
			// TODO
			Register reg = cg.rm.getRegister();
			cg.emit.emitMove(constant(0), reg);
			return reg;
		}
	}

	@Override
	public Register thisRef(ThisRef ast, VarLocation arg) {
		System.out.println("==ThisRef");
		// TODO
		// {
		// throw new ToDoException();
		// }
		return cg.rm.getRegister();
	}

	@Override
	public Register methodCall(MethodCallExpr ast, VarLocation arg) {
		System.out.println("==Expr-MethodCall");
		List<Expr> args = ast.argumentsWithoutReceiver();
		// Make space for arguments
		cg.emit.emit("subl", args.size() * 4, cg.rm.STACK_REG); // TODO 4?
		cg.currentStackPointerOffset -= args.size() * 4;
		
		//push arguments
		int offset = 0;
		for (Expr argument : args) {
			// TODO add emitMove(reg, offset, baseP) -> emitStore
			String dest = offset + "(" + cg.rm.STACK_REG.repr + ")";
			Register reg = cg.eg.gen(argument, arg);
			cg.emit.emitMove(reg, dest);
			cg.rm.releaseRegister(reg);
			offset += 4;
		}
		
		//check nullPointer
		if (ast.receiver() instanceof Ast.Var) {
			Var v = (Ast.Var) ast.receiver();
			System.out.println(v.name);
			if (!AstCodeGenerator.objectTables.containsKey(v.name)) {
				System.out.println("NULLPOINTER_EXCEPTION");

				cg.emit.emit("subl", 4, cg.rm.STACK_REG);
				cg.emit.emit("movl", "$4", "0(" + cg.rm.STACK_REG + ")"); // Exit
																			// Code
																			// 4:
																			// NullPointerException
				cg.emit.emit("call", Config.EXIT);
				cg.emit.emit("addl", 4, cg.rm.STACK_REG);
			}
		}

		
		String calledClass = ast.receiver().type.name;

		// TODO receiver
		VTable vTable = AstCodeGenerator.classTables.get(calledClass); // TODO
																		// Main
																		// harcoded

		Register reg = cg.rm.getRegister();

		// Load adress of CalledFnc
		cg.emit.emit("leal", calledClass, reg);

		// Add Offset of method
		int offSet = vTable.getMethodOffset(ast.methodName);

		cg.emit.emit("addl", "$" + offSet, reg);

		cg.emit.emit("movl", "0(" + reg + ")", reg);
		cg.emit.emit("call", "*" + reg);

		cg.rm.releaseRegister(reg);
		System.out.println("----------------------------------------");

		// Return value

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
		System.out.println("==Var");
		{
			Register reg = cg.rm.getRegister();
			
			if (ast.sym.kind == Kind.FIELD) {
				VTable vt = AstCodeGenerator.classTables.get(arg.currentClass);
				int offSet = vt.getFieldOffset(ast.name);
				cg.emit.emit("movl", offSet + "(" + cg.rm.BASE_REG + ")", reg);
				cg.emit.emit("movl", 0 + "(" + reg + ")", reg);	
			}
			if (ast.sym.kind == Kind.LOCAL) {
				String loc = arg.getVariableLocation(ast.name);
				cg.emit.emit("movl", loc, reg);
			}
			
			
			return reg;
		}
	}

}
