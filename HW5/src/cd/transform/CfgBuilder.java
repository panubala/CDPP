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

		cfg.start = cfg.end = cfg.newBlock();
		BasicBlock finalBlock = cfg.newBlock();
		
		visit(mdecl.body(), cfg);	
		
		cfg.connect(cfg.end, finalBlock);

		// CFG and AST are not synchronized, only use CFG from now on
		mdecl.setBody(null);

	}

	@Override
	public Void assign(Assign ast, ControlFlowGraph arg) {
		arg.end.stmts.add(ast);
		return null;
	}

	@Override
	public Void builtInWrite(BuiltInWrite ast, ControlFlowGraph arg) {
		arg.end.stmts.add(ast);
		return null;
	}

	@Override
	public Void builtInWriteln(BuiltInWriteln ast, ControlFlowGraph arg) {
		arg.end.stmts.add(ast);
		return null;
	}

	@Override
	public Void returnStmt(ReturnStmt ast, ControlFlowGraph arg) {
		arg.end.stmts.add(ast);
		return null;
	}


	@Override
	public Void methodCall(MethodCall ast, ControlFlowGraph arg) {
		arg.end.stmts.add(ast);
		return null;
	}
	
	@Override
	public Void nop(Nop ast, ControlFlowGraph arg) {
		arg.end.stmts.add(ast);
		return null;
	}

	@Override
	public Void ifElse(IfElse ast, ControlFlowGraph cfg) {
		
		BasicBlock condBlock = cfg.end;
		cfg.terminateInCondition(condBlock, ast.condition());
		
		cfg.end = condBlock.trueSuccessor();
		visit(ast.then(), cfg);
		BasicBlock endTrue = cfg.end;
		
		cfg.end = condBlock.falseSuccessor();
		visit(ast.otherwise(), cfg);
		BasicBlock endFalse = cfg.end;
		
		BasicBlock after = cfg.newBlock();
		cfg.connect(endTrue, after);
		cfg.connect(endFalse, after);
		
		cfg.end = after;
		
		return null;
	}

	@Override
	public Void whileLoop(WhileLoop ast, ControlFlowGraph cfg) {
		
		BasicBlock loopBlock = cfg.newBlock();
		cfg.connect(cfg.end, loopBlock);
		
		cfg.terminateInCondition(loopBlock, ast.condition());
		
		cfg.end = loopBlock.trueSuccessor();
		visit(ast.body(), cfg);
		cfg.connect(cfg.end, loopBlock);
		
		cfg.end = loopBlock.falseSuccessor();
		
		return null;
	}
}
