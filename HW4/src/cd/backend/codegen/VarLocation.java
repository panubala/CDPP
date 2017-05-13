package cd.backend.codegen;

import java.util.HashMap;

public class VarLocation {

	private HashMap<String, Integer> varLocation;
	private AstCodeGenerator cg;

	public VarLocation(AstCodeGenerator astCodeGenerator) {
		this.varLocation = new HashMap();
		this.cg = astCodeGenerator;
	}

	private int getVariableOffset(String variableName) {

		if (!varLocation.containsKey(variableName)) { // The variable isnt
														// stored on the stack
			
			System.out.println("==Variable " + variableName + " is currently not stored on the stack");
			cg.emit.emit("addl", "$-4", cg.rm.STACK_REG); // move the
															// stackpointer

			cg.currentStackPointerOffset -= 4;
			varLocation.put(variableName, cg.currentStackPointerOffset);
		}
		return varLocation.get(variableName);
	}

	public String getVariableLocation(String variableName) {
		return getVariableOffset(variableName) + "(" + cg.rm.BASE_REG.repr + ")";
	}

	public void putParameters(String parameterName, int offSet) { // offset has
																	// to be
																	// positiv
		varLocation.put(parameterName, offSet);
	}

}
