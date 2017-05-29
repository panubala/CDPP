package cd.transform.analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cd.ToDoException;
import cd.ir.Ast.Assign;
import cd.ir.Ast.BinaryOp;
import cd.ir.Ast.Expr;
import cd.ir.Ast.Field;
import cd.ir.Ast.MethodDecl;
import cd.ir.Ast.Stmt;
import cd.ir.Ast.UnaryOp;
import cd.ir.BasicBlock;
import cd.ir.Symbol.VariableSymbol;

/**
 * A data-flow analysis that determines if a variable is guaranteed to be non-<code>null</code> at a
 * given point in the program. The state of this analysis represents the set of
 * non-<code>null</code> variables.
 */
public class NonNullAnalysis extends DataFlowAnalysis<Set<VariableSymbol>> {
	
//	private Map<BasicBlock, Set<Expr>> kill = new HashMap<>();
//	private Map<BasicBlock, Set<Expr>> gen = new HashMap<>();
	private Map<BasicBlock, Set<VariableSymbol>> def = new HashMap<>();
	private Map<BasicBlock, Set<VariableSymbol>> use = new HashMap<>();
	private Map<Stmt, BasicBlock> statements = new HashMap<>();
	
	
	public NonNullAnalysis(MethodDecl method) {
		super(method.cfg);
		if(method.cfg == null)
			throw new IllegalArgumentException("method is missing CFG");
		
		//def and use computed for each block
		
		super.iterate();
		
		Set<VariableSymbol> defSymbols;
		Set<VariableSymbol> useSymbols;
		
		
		
		for(BasicBlock block: method.cfg.allBlocks){
			defSymbols = new HashSet<>();
			useSymbols = new HashSet<>();
			
			for (Stmt stmt : block.stmts) {
				statements.put(stmt, block);
				if (stmt instanceof Assign){
					defSymbols.addAll(getVariableSymbol(((Assign) stmt).left()));
					useSymbols.addAll(getVariableSymbol(((Assign) stmt).right()));	
				}	
			}
			
//			if(!defSymbols.isEmpty()){
				use.put(block, defSymbols);	
//			}
			
			
			
//			if(!useSymbols.isEmpty()){
				use.put(block, useSymbols);	
//			}
			
		}
		System.out.println("=="+def.toString() + use.toString());
		
		
	}
	
	@Override
	protected Set<VariableSymbol> initialState() {
		System.out.println("==InitialState");
		return new HashSet<VariableSymbol>();
	}
	
	
	
	@Override
	protected Set<VariableSymbol> startState() {
		System.out.println("==StartState");
		return new HashSet<VariableSymbol>();
	}
	
	@Override
	protected Set<VariableSymbol> transferFunction(BasicBlock block, Set<VariableSymbol> inState) {
		System.out.println("== TransferFunction");
		Set<VariableSymbol> result = new HashSet<VariableSymbol>();

		if (!(use.get(block)==null)){
			result.addAll(use.get(block));
		}
		
		
		for (VariableSymbol sym : inState){
			if(!def.get(block).contains(sym)){
				result.add(sym);
			}		
		}
		
		System.out.println("==After Transfer Function:" + result);
		return result;
	}
	
	private Set<VariableSymbol> getVariableSymbol(Expr expr){
		Set<VariableSymbol> symbols = new HashSet<VariableSymbol>();
		
		if(expr instanceof Field){
			
			Field field = (Field) expr;
			symbols.add(field.sym);
			
		}else if(expr instanceof BinaryOp){
			
			BinaryOp binaryOp = (BinaryOp) expr;
			symbols.addAll(getVariableSymbol(binaryOp.left()));
			symbols.addAll(getVariableSymbol(binaryOp.right()));
			
		}else if(expr instanceof UnaryOp){
			
			UnaryOp unaryOp = (UnaryOp) expr;
			symbols.addAll(getVariableSymbol(unaryOp.arg()));
		}
		
		return symbols;
	}
	
	@Override
	protected Set<VariableSymbol> join(Set<Set<VariableSymbol>> states) {
		System.out.println("==Join");
		Set<VariableSymbol> join = new HashSet<VariableSymbol>();
		for(Set<VariableSymbol> sets: states){
			join.addAll(sets);
		}
		return join;
				
	}
	
	/**
	 * Returns the set of variables that are guaranteed to be non-<code>null</code> before
	 * the given statement.
	 */
	public Set<VariableSymbol> nonNullBefore(Stmt stmt) {
		System.out.println("==nonNullBefore");
		BasicBlock block = statements.get(stmt);
		return use.get(block);
	}
	
	/**
	 * Returns the set of variables that are guaranteed to be non-<code>null</code> before
	 * the condition of the given basic block.
	 */
	public Set<VariableSymbol> nonNullBeforeCondition(BasicBlock block) {
		System.out.println("==nonNullBeforeCondition");
		return use.get(block);
	}
}
