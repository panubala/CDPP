package cd.transform;

import cd.ToDoException;
import cd.ir.Ast;
import cd.ir.Ast.Assign;
import cd.ir.Ast.IfElse;
import cd.ir.Ast.MethodDecl;
import cd.ir.Ast.WhileLoop;
import cd.ir.AstVisitor;
import cd.ir.BasicBlock;
import cd.ir.ControlFlowGraph;

public class CfgBuilder extends AstVisitor<BasicBlock, BasicBlock>{
	
	ControlFlowGraph cfg;
	
	public void build(MethodDecl mdecl) {
		System.out.println("==Build");
		cfg = mdecl.cfg = new ControlFlowGraph();
		
		cfg.start = cfg.newBlock(); // Note: Use newBlock() to create new basic blocks
		System.out.println("==Start "+ cfg.start);
		cfg.end = cfg.newBlock(); // unique exit block to which all blocks that end with a return stmt. lead
		System.out.println("==End " + cfg.end);
		
		
		visit(mdecl.body(), cfg.start);
		
		System.out.println(cfg.allBlocks);
		
		//throw new ToDoException();
		
		// CFG and AST are not synchronized, only use CFG from now on
		mdecl.setBody(null);
		
	}
	

	
	@Override
	public BasicBlock ifElse(IfElse ast, BasicBlock arg) {
		
		BasicBlock ifBlock = cfg.newBlock();
		cfg.connect(arg,ifBlock);
		cfg.terminateInCondition(ifBlock, ast.condition());
		
		return null;
	}


	@Override
	public BasicBlock whileLoop(WhileLoop ast, BasicBlock arg) {
		// TODO Auto-generated method stub
		return super.whileLoop(ast, arg);
	}


	

}
