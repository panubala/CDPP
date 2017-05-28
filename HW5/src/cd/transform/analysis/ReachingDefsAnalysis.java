package cd.transform.analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import cd.ir.Ast;
import cd.ir.Ast.Assign;
import cd.ir.Ast.Expr;
import cd.ir.Ast.MethodDecl;
import cd.ir.Ast.Stmt;
import cd.ir.Ast.Var;
import cd.ir.BasicBlock;
import cd.ir.ControlFlowGraph;
import cd.ir.Symbol.VariableSymbol.Kind;
import cd.transform.analysis.ReachingDefsAnalysis.Def;
import cd.util.debug.AstOneLine;

/**
 * Computes the sets of reaching definitions for each basic block.
 */
public class ReachingDefsAnalysis extends DataFlowAnalysis<Set<Def>> {

	/**
	 * Perform reaching definitions analysis.
	 * 
	 * @param cfg
	 *            {@link ControlFlowGraph} of a {@link MethodDecl}
	 */
	public ReachingDefsAnalysis(ControlFlowGraph cfg) {
		super(cfg);
		super.iterate();
	}

	@Override
	protected Set<Def> initialState() {
		return new HashSet<Def>();
	}

	@Override
	protected Set<Def> startState() {
		return new HashSet<Def>();
	}

	private Map<BasicBlock, Set<Expr>> kill = new HashMap<>();
	private Map<BasicBlock, Set<Expr>> gen = new HashMap<>();

	@Override
	protected Set<Def> transferFunction(BasicBlock block, Set<Def> inState) {
		for (Stmt stmt : block.stmts) {
			if (stmt instanceof Assign) {
				Assign ass = (Assign) stmt;
				Def d = new Def(ass);

				Iterator<Def> iter = inState.iterator();
				while (iter.hasNext()) {
					if (iter.next().target.equals(d.target)) {
						iter.remove();
					}
				}
				inState.add(d);
			}
		}

		return inState;
	}

	@Override
	protected Set<Def> join(Set<Set<Def>> states) {
		Set<Def> joinSet = new HashSet<Def>();
		System.out.println(states);
		for (Set<Def> set : states) {
			joinSet.addAll(set);
		}
		return joinSet;
	}

	/**
	 * Class representing a definition in the {@link Ast} of a method.
	 */
	public static class Def {
		public final Assign assign;
		public final String target;

		/**
		 * Create a {@link Def} from an {@link Assign} of the form
		 * <code>var = ...</code>
		 */
		public Def(Assign assign) {
			if (!(assign.left() instanceof Var) || ((Var) assign.left()).sym.kind == Kind.FIELD)
				throw new IllegalArgumentException("definitions must have (local) variable on LHS");

			this.assign = assign;
			this.target = ((Var) assign.left()).name;
		}

		@Override
		public String toString() {
			return AstOneLine.toString(assign);
		}
	}
}
