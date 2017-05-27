package cd.transform;

import cd.ir.Ast.Assign;
import cd.ir.Ast.BuiltInWrite;
import cd.ir.Ast.BuiltInWriteln;
import cd.ir.Ast.IfElse;
import cd.ir.Ast.MethodCall;
import cd.ir.Ast.MethodDecl;
import cd.ir.Ast.Nop;
import cd.ir.Ast.ReturnStmt;
import cd.ir.Ast.Seq;
import cd.ir.Ast.WhileLoop;
import cd.ir.AstVisitor;
import cd.ir.BasicBlock;
import cd.ir.ControlFlowGraph;

public class CfgBuilder extends AstVisitor<Void, ControlFlowGraph> {

	public void build(MethodDecl mdecl) {
		System.out.println("==Build");
		ControlFlowGraph cfg = mdecl.cfg = new ControlFlowGraph();

		cfg.start = cfg.newBlock();
		cfg.end = cfg.newBlock();

		BasicBlock startBlock = cfg.start;
		BasicBlock finalBlock = cfg.end;

		visit(mdecl.body(), cfg);
		if (!cfg.start.successors.contains(cfg.end))
			cfg.connect(cfg.start, finalBlock);
		cfg.start = startBlock;

		// CFG and AST are not synchronized, only use CFG from now on
		mdecl.setBody(null);

	}

	@Override
	public Void assign(Assign ast, ControlFlowGraph arg) {
		if (!arg.start.successors.contains(arg.end)) {
			arg.start.stmts.add(ast);
		}
		return null;
	}

	@Override
	public Void builtInWrite(BuiltInWrite ast, ControlFlowGraph arg) {
		if (!arg.start.successors.contains(arg.end)) {
			arg.start.stmts.add(ast);
		}
		return null;
	}

	@Override
	public Void builtInWriteln(BuiltInWriteln ast, ControlFlowGraph arg) {
		if (!arg.start.successors.contains(arg.end)) {
			arg.start.stmts.add(ast);
		}
		return null;
	}

	@Override
	public Void returnStmt(ReturnStmt ast, ControlFlowGraph arg) {
		if (!arg.start.successors.contains(arg.end)) {
			arg.start.stmts.add(ast);
			arg.connect(arg.start, arg.end);
		}
		return null;
	}

	@Override
	public Void methodCall(MethodCall ast, ControlFlowGraph arg) {
		if (!arg.start.successors.contains(arg.end)) {
			arg.start.stmts.add(ast);
		}
		return null;
	}

	@Override
	public Void nop(Nop ast, ControlFlowGraph arg) {
		if (!arg.start.successors.contains(arg.end)) {
			arg.start.stmts.add(ast);
		}
		return null;
	}

	@Override
	public Void ifElse(IfElse ast, ControlFlowGraph cfg) {
		if (!cfg.start.successors.contains(cfg.end)) {
			BasicBlock condBlock = cfg.start;
			cfg.terminateInCondition(condBlock, ast.condition());

			cfg.start = condBlock.trueSuccessor();
			visit(ast.then(), cfg);
			BasicBlock endTrue = cfg.start;

			cfg.start = condBlock.falseSuccessor();
			visit(ast.otherwise(), cfg);
			BasicBlock endFalse = cfg.start;

			BasicBlock after = cfg.newBlock();
			if (!endTrue.successors.contains(cfg.end)) // not already terminated
				cfg.connect(endTrue, after);
			if (!endFalse.successors.contains(cfg.end))
				cfg.connect(endFalse, after);

			cfg.start = after;
		}
		return null;
	}

	@Override
	public Void whileLoop(WhileLoop ast, ControlFlowGraph cfg) {
		if (!cfg.start.successors.contains(cfg.end)) {
			BasicBlock loopBlock = cfg.newBlock();
			cfg.connect(cfg.start, loopBlock);

			cfg.terminateInCondition(loopBlock, ast.condition());

			cfg.start = loopBlock.trueSuccessor();
			visit(ast.body(), cfg);
			if (!cfg.start.successors.contains(cfg.end)) // Loop body didnt
															// terminated
				cfg.connect(cfg.start, loopBlock);

			cfg.start = loopBlock.falseSuccessor();
		}
		return null;
	}
}
