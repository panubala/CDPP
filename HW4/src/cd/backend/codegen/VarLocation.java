package cd.backend.codegen;

import java.util.HashMap;

public class VarLocation {

	private HashMap<String, Integer> varLocation;
	private AstCodeGenerator cg;

	public VarLocation(AstCodeGenerator astCodeGenerator) {
		this.varLocation = new HashMap();
		this.cg = astCodeGenerator;
	}
	
	public String currentClass;
	
	public int numberOfParameters;

	private int getVariableOffset(String variableName) {
		if (!varLocation.containsKey(variableName)) { // The variable does not exist local
			
			System.out.println("==Variable " + variableName + " is currently not stored on the stack");
			cg.emit.emit("addl", "$-4", cg.rm.STACK_REG); // move the
															// stackpointer
			cg.currentStackPointerOffset -= 4;

			System.out.println(">>>>StackPointer is now at: " + cg.currentStackPointerOffset);
			varLocation.put(variableName, cg.currentStackPointerOffset);
		}
		return varLocation.get(variableName);
	}

	public String getVariableLocation(String variableName) {
		if (getVariableOffset(variableName) == -70) return null;
		return getVariableOffset(variableName) + "(" + cg.rm.BASE_REG.repr + ")";
	}

	public void putParameters(String parameterName, int offSet) { // offset has
																	// to be
																	// positiv
		varLocation.put(parameterName, offSet);
	}
	
	public String toString(){
		String s = new String();
		
		for(String k : varLocation.keySet()){
			
			s = s + k + " -> " + varLocation.get(k) + "\n";
		}
		
		return s;
	}

}
