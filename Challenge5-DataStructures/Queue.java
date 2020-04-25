import java.awt.Color;
import java.util.LinkedList;

/**
 * @author fred wu
 *
 */

public class Queue {
	/**
	 * Adds the value to the front of the queue. Note the queue automatically
	 * resizes as more items are added.
	 */

	private LinkedList<Double> q;

	public Queue() {
		q = new LinkedList<Double>();
	}

	public void add(double value) {
		q.addFirst(value);
	}

	/**
	 * Removes the value from the end of the queue. If the queue is empty,
	 * returns 0
	 */
	public double remove() {
		if (q.size() > 0) {
			Double last = q.removeLast();
			return last;
		} else {
			return 0;
		}
	}

	/** Returns the number of items in the queue. */
	public int length() {
		return q.size();
	}

	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		return q.size() == 0;
	}

	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		String rst = "";
		if (q.size() == 0) {
			System.out.println("size 0");
		} else {

			rst = rst.concat(String.valueOf(q.get(q.size() - 1)));
			for (int i = q.size() - 2; i >= 0; i--) {
				System.out.println("index");
				System.out.println(q.get(i));
				rst = rst.concat(",");
				rst = rst.concat(String.valueOf(q.get(i)));
			}
		}
		return rst;
	}
}
