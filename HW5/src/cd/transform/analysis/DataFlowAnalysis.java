package cd.transform.analysis;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import cd.ir.BasicBlock;
import cd.ir.ControlFlowGraph;

/**
 * The abstract superclass of all data-flow analyses. This class provides a
 * framework to implement concrete analyses by providing
 * {@link #initialState()}, {@link #startState()},
 * {@link #transferFunction(BasicBlock, Object)}, and {@link #join(Set)}
 * methods.
 * 
 * @param <State>
 *            The type of states the analysis computes, specified by a concrete
 *            subclass. Typically, this is a set or map type.
 */
public abstract class DataFlowAnalysis<State> {

	protected final ControlFlowGraph cfg;
	private Map<BasicBlock, State> inStates;
	private Map<BasicBlock, State> outStates;

	public DataFlowAnalysis(ControlFlowGraph cfg) {
		this.cfg = cfg;
		this.inStates = new HashMap<>();
		this.outStates = new HashMap<>();
	}

	/**
	 * Returns the in-state of basic block <code>block</code>.
	 */
	public State inStateOf(BasicBlock block) {
		return inStates.get(block);
	}

	/**
	 * Returns the out-state of basic block <code>block</code>.
	 */
	public State outStateOf(BasicBlock block) {
		return outStates.get(block);
	}

	/**
	 * Do forward flow fixed-point iteration until out-states do not change
	 * anymore. Subclasses should call this method in their constructor after
	 * the required initialization.
	 */
	protected void iterate() {


		// For all Blocks without the last one:
		State inState = initialState();

		boolean change = true;
		while (change) {
			change = false;
			Map<BasicBlock, State> oldOutStates = new HashMap<BasicBlock, State>(outStates);
			System.out.println("OutStates: " + oldOutStates);
			
			//Go through all Blocks and adjust their in/outStates
			for (BasicBlock block : cfg.allBlocks) {
				Set<State> outStatesPre = new LinkedHashSet<>();
				outStatesPre.add(initialState());
				
				
				
				//Get all outStates of the predecessors and put them into one inSet
				for (BasicBlock predecessor : block.predecessors) {
					if (outStateOf(predecessor) != null) {
						outStatesPre.add(outStateOf(predecessor));
					}
				}
				inState = join(outStatesPre);
				
				if(inStates.containsKey(block) && inStateOf(block).toString().equals(inState.toString())){
					//The inputSets didnt change -> no need to colculate new outSet
				}else{
					//InSet changed
					inStates.put(block, inState);
					State outState = transferFunction(block, inState);
					outStates.put(block, outState);
					
				}
			}
			
			if(oldOutStates.keySet().size() == 0) change = true;
			
			//Check if the outStates changed, if they didnt, we can stop the loop
			for(BasicBlock k : oldOutStates.keySet()){				
				if(!oldOutStates.get(k).toString().equals(outStates.get(k).toString())){
					change = true;
				}
			}
		}

	}

	/**
	 * Returns the initial state for all blocks except the
	 * {@link ControlFlowGraph#start start} block.
	 */
	protected abstract State initialState();

	/**
	 * Returns the initial state for the {@link ControlFlowGraph#start start}
	 * block.
	 */
	protected abstract State startState();

	/**
	 * Calculates the out-state for a basic block <code>block</code> and an
	 * in-state <code>inState</code>
	 */
	protected abstract State transferFunction(BasicBlock block, State inState);

	/**
	 * Merges together several out-states and returns the in-state for the
	 * transfer function.
	 */
	protected abstract State join(Set<State> states);
}
