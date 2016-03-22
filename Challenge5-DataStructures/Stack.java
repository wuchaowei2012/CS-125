
public class Stack {
	/** Adds a value to the top of the stack.*/
	private String []stack = new String[0];
	private int size = 0;
	
	public void push(String value){
		size++;
		String []temp = stack;
		stack = new String[size];
		for(int i = 0; i < size-1; i++){
			stack[i] = temp[i];	
		}
		stack[size-1] = value;
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		if(size == 0)
			return null;
		String []temp = stack;
		size--;
		stack = new String[size];
		for(int i = 0; i < size; i++){
			stack[i] = temp[i];
		}
		return temp[size];
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek() {
		if(size == 0)
			return null;
		return stack[size-1];
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return size;
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString() {
		String ret = "";
		for(int i = 0; i < size; i++){
			ret = ret + stack[i] + "\n";
		}
		return ret;
	}
}
