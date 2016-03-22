/**
 * Complete the following GeocacheList, to ensure all unit tests pass.
 * There are several errors in the code below
 *
 * Hint: Get the Geocache class working and passing its tests first.
 * @author ywang443
 */
public class GeocacheList {
	private Geocache[] data = new Geocache[0];
	private int size = 0;

	public Geocache getGeocache(int i) {
		return data[i];
	}

	public int getSize() {
		return size;
	}

	public GeocacheList() {
	}

	public GeocacheList(GeocacheList other, boolean deepCopy) {
		if(deepCopy){
			for(int i = 0; i < other.data.length; i++){
				add(other.data[i]);
				data[i] = new Geocache(other.data[i]);
			}
		}
		else{
			for(int i = 0; i < other.data.length; i++){
				add(other.data[i]);
				data[i].setX(other.data[i].getX());
				data[i].setY(other.data[i].getY());
			}
		}
		size = other.getSize();
	}

	public void add(Geocache p) {
		size++;
		if (size > data.length) {
			Geocache[] old = data;
			data = new Geocache[size * 2];
			for (int i = 0; i < old.length; i++)
				data[i] = old[i];
		}
		data[size-1] = p;
	}

	public GeocacheList removeFromTop() {
		this.size--;
		GeocacheList other = new GeocacheList();
		for(int i = 0; i < other.getSize(); i++){
			other.data[i] = this.data[i];
		}
		return other;
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