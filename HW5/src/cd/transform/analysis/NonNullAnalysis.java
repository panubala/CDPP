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
import cd.ir.Ast.Var;
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
		
		
		Set<VariableSymbol> defSymbols;
		Set<VariableSymbol> useSymbols;
		
		
		
		for(BasicBlock block: method.cfg.allBlocks){
			defSymbols = new HashSet<>();
			useSymbols = new HashSet<>();
			
			for (Stmt stmt : block.stmts) {
				statements.put(stmt, block);
				
				System.out.println("== Statement: " + stmt.toString());
				if (stmt instanceof Assign){
					defSymbols.addAll(getVariableSymbol(((Assign) stmt).left()));
					useSymbols.addAll(getVariableSymbol(((Assign) stmt).right()));	
				}	
				
				System.out.println(defSymbols.toString() + useSymbols.toString());
			}
			
				def.put(block, defSymbols);	

				use.put(block, useSymbols);	

			
		}
		System.out.println("=="+ "Def: " + def.toString() + "Use: " + use.toString());
		
		super.iterate();
		
		
		
		
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
		System.out.println("== TransferFunction: " + block.toString());
		Set<VariableSymbol> result = new HashSet<VariableSymbol>();
		for (Stmt stmt: block.stmts ){
			if (stmt instanceof Assign){
				outStateOf(block);
			}
		}
		if (!(def.get(block)==null)){
			result.addAll(def.get(block));
		}
		
		
		for (VariableSymbol sym : inState){
			if(!use.get(block).contains(sym)){
				result.add(sym);
			}		
		}
		
		System.out.println("==After Transfer Function:" + result);
		return result;
	}
	
	private Set<VariableSymbol> getVariableSymbol(Expr expr){
		Set<VariableSymbol> symbols = new HashSet<VariableSymbol>();
		
		
		if(expr instanceof Var){
			
			Var var = (Var) expr;
			symbols.add(var.sym);
			
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
		System.out.println("Block: " + block.toString() + " Statements: " + block.stmts.toString());
		
		
		Set<VariableSymbol> symbls = new HashSet<>();
		
		int i = 1;
		Stmt s = block.stmts.get(0);
		while(s != stmt){
			
			if (s instanceof Assign){
				symbls.addAll(getVariableSymbol(((Assign) s).left()));		
			}
			s = block.stmts.get(i);
		}
		
		int size;
		size = block.predecessors.size();
		System.out.println("Size of Predecessors: " + size);
		return symbls;
	}
	
	/**
	 * Returns the set of variables that are guaranteed to be non-<code>null</code> before
	 * the condition of the given basic block.
	 */
	public Set<VariableSymbol> nonNullBeforeCondition(BasicBlock block) {
		System.out.println("==nonNullBeforeCondition");
		Set<VariableSymbol>  result = new HashSet<VariableSymbol>();
		
		System.out.println("Def in nonNullBeforeCondition: " + def.toString());
		
		for(BasicBlock b: block.predecessors){
			result.addAll(def.get(b));
			System.out.println(result.toString());
		}
		
		result.addAll(def.get(block));
		
		System.out.println("==nonNullBeforeCondition's output: " +result.toString());
		return result;
	}
}
