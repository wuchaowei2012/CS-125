
public class Queue {
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. */
	private double []queue = new double[0];
	private int size = 0;
	
	public void add(double value) {
		size++;
		double []temp = queue;
		queue = new double[size];
		queue[0] = value;
		for(int i = 1; i < size; i++){
			queue[i] = temp[i-1];			
		}
	}
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if(size == 0)
			return 0;
		size--;
		double []temp = queue;
		for(int i = 0; i < size; i++){
			queue[i] = temp[i];
		}
		return temp[size];
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
		ret = ret + queue[size - 1];
		for(int i = size - 2; i > -1; i--){
			ret = ret + "," + queue[i];
		}
		return ret;
	}
}
