
public class Queue {
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	private double []queue = new double[0];
	private int size = 0;
	
	public void add(double value) {
		size++;
		double []temp = queue;
		queue = new double[size];
		for(int i = 0; i < size-1; i++){
			queue[i] = temp[i];	
		}
		queue[size-1] = value;
	}
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if(size == 0)
			return 0;
		double []temp = queue;
		size--;
		queue = new double[size];
		for(int i = 0; i < size; i++){
			queue[i] = temp[i+1];
		}
		return temp[0];
	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		return size;	
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		String ret = "";
		for(int i = 0; i < size - 1; i++){
			ret = ret + queue[i] + ",";
		}
		ret = ret + queue[size - 1];
		return ret;
	}
}
