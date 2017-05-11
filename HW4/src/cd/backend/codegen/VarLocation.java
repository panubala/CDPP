package cd.backend.codegen;

import java.util.HashMap;

public class VarLocation {

	private HashMap<String, Integer> varLocation;
	private AstCodeGenerator cg;

	public VarLocation(AstCodeGenerator astCodeGenerator) {
		this.varLocation = new HashMap();
		this.cg = astCodeGenerator;
	}

	public int getVariableOffset(String variableName) {

		if (!varLocation.containsKey(variableName)) {
			cg.emit.emit("addl", "$4", cg.rm.STACK_REG);

			cg.currentStackPointerOffset -= 4;
			varLocation.put(variableName, cg.currentStackPointerOffset);
		}
		return varLocation.get(variableName);
	}

	public String getVariableLocation(String variableName) {
		return getVariableOffset(variableName) + "(" + cg.rm.BASE_REG.repr + ")";
	}

}
