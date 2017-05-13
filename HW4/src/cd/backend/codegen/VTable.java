package cd.backend.codegen;

import java.util.HashMap;

public class VTable {
	
	//A VTable represents a class
	
	public VTable(String name){
		this.className = name;
	}
	
	public final String className;
	
	private HashMap<String, Integer> methods = new HashMap();  //method name to method pointer
	private HashMap<String, Integer> fields = new HashMap();  //method name to method pointer
	
	
	public void addMethod(String methodName, int methodOffset){
		methods.put(methodName, methodOffset*4);	
	}
	
	public void addField(String fieldName, int fieldOffset){
		fields.put(fieldName, fieldOffset*4);		
	}
	
	public int getMethodOffset(String methodName){
		return methods.get(methodName);
	}
	
	public int getFieldOffset(String fieldName){
		return fields.get(fieldName);
	}
	
}
