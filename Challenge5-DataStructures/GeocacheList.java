/**
 * @author fred wu
 *
 */

/**
 * Complete the following GeocacheList, to ensure all unit tests pass. There are
 * several errors in the code below
 *
 * Hint: Get the Geocache class working and passing its tests first.
 */
public class GeocacheList {
	private Geocache[] data = new Geocache[0];
	private int size = 0;

	public Geocache getGeocache(int i) {
		return this.data[i];
	}

	public int getSize() {
		return this.size;
	}

	public GeocacheList() {
		// return this.data;
	}

	public GeocacheList(GeocacheList other, boolean deepCopy) {
		data = new Geocache[other.data.length];
		size = other.size;
		int sz = other.data.length;

		if (deepCopy) {
			for (int i = 0; i < sz; i++) {
				data[i] = new Geocache(other.data[i]);  // 这个是所谓的深层拷贝
			}
		} else {
			for (int i = 0; i < sz; i++) {
				data[i] = other.data[i];  //这个就是所谓的浅拷贝
			}

		}

	}

	public void add(Geocache p) {
		size++;
		if (size > data.length) {
			Geocache[] old = data;
			data = new Geocache[size * 2];
			for (int i = 0; i < old.length; i++)
				data[i] = old[i];
		}
		data[size - 1] = p;
	}

	public Geocache removeFromTop() {
		size --;
		return null;
	}

	public String toString() {
		StringBuffer s = new StringBuffer("GeocacheList:");
		for (int i = 0; i < size; i++) {
			if (i > 0)
				s.append(',');
			s.append(data[i]);
		}
		return s.toString();
	}
}