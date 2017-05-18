package cd.backend.codegen;

import java.util.HashMap;
import java.util.HashSet;

public class VarLocation {

	private HashMap<String, Integer> varLocation;
	private HashSet<String> createdObjects;
	private AstCodeGenerator cg;

	public VarLocation(AstCodeGenerator astCodeGenerator) {
		this.varLocation = new HashMap();
		this.cg = astCodeGenerator;
	}
	
	public void createObject(String name){
		createdObjects.add(name);
	}
	
	public boolean objectExist(String name){
		return createdObjects.contains(name);
	}
	
	public String currentClass;
	
	public int numberOfParameters;
	
	public int currentStackPointerOffset;
	
	public boolean calculateValue = true; //if false -> calculate Adress

	private int getVariableOffset(String variableName) {
		if (!varLocation.containsKey(variableName)) { // The variable does not exist local
			
			System.out.println("==Variable " + variableName + " is currently not stored on the stack");
			cg.emit.emit("addl", "$-4", cg.rm.STACK_REG); // move the
															// stackpointer
			currentStackPointerOffset -= 4;

			System.out.println(">>>>StackPointer is now at: " + currentStackPointerOffset);
			varLocation.put(variableName, currentStackPointerOffset);
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
	
	public String toString(){
		String s = new String();
		
		for(String k : varLocation.keySet()){
			
			s = s + k + " -> " + varLocation.get(k) + "\n";
		}
		
		return s;
	}

}
