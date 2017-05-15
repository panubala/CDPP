package cd.backend.codegen;

import java.util.HashMap;

public class VTable {

	// A VTable represents a class

	public VTable(String name) {
		this.className = name;
	}

	public final String className;

	private HashMap<String, Integer> methods = new HashMap<String, Integer>(); // method
																				// name
																				// to
																				// method
																				// pointer
	private HashMap<String, Integer> fields = new HashMap<String, Integer>(); // method
																				// name
																				// to
																				// method
																				// pointer

	public void addMethod(String methodName, int methodOffset) {
		methods.put(methodName, methodOffset * 4);
	}

	public int numberOfField() {
		return fields.size();
	}

	public void addField(String fieldName, int fieldOffset) {
		fields.put(fieldName, fieldOffset);
	}

	public boolean contains(String name) {
		return methods.containsKey(name) || fields.containsKey(name);
	}

	public int getMethodOffset(String methodName) {
		return methods.get(methodName);
	}

	public int getFieldOffset(String fieldName) {
		return fields.get(fieldName);
	}

	public VTable copy() {
		VTable newVT = new VTable(this.className);
		newVT.fields = (HashMap) this.fields.clone();
		newVT.methods = (HashMap) this.methods.clone();

		return newVT;

	}

	public String toString() {
		String s = new String();

		for (String f : fields.keySet()) {
			s = s + f + " -> " + fields.get(f);
			s += "\n";
		}
		s += "--------------\n";

		for (String m : methods.keySet()) {
			s = s + m + " -> " + methods.get(m);
			s += "\n";
		}

		return s;

	}

}
