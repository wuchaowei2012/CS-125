import java.util.LinkedList;

/**
 * @author fred wu
 *
 */

public class Stack {
	/** Adds a value to the top of the stack. */
	private LinkedList<String> q;

	public Stack() {
		q = new LinkedList<String>();
	}

	public void push(String value) {
		q.addFirst(value);
	}

	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		if (q.size() == 0) {
			return null;
		}
		return q.pop();
	}

	/**
	 * Returns the topmost string but does not remove it. If the stack is empty,
	 * returns null.
	 */
	public String peek() {
		if (q.isEmpty()){
			return null;
		}
		return q.getFirst();
	}

	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		return q.isEmpty();
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return q.size();
	}

	/**
	 * Returns a string representation of the stack. Each string is separated by
	 * a newline. Returns an empty string if the stack is empty.
	 */
	public String toString() {
		String rst = "";
		if (q.size() == 0) {
			System.out.println("size 0");
		} else {

			for (int i = q.size() - 1; i >= 0; i--) {
				System.out.println("index");
				System.out.println(q.get(i));

				rst = rst.concat(q.get(i));
				rst = rst.concat("\n");
			}
		}
		return rst;
	}
}
