
/**
 * @author fred wu
 *
 */

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class KeyValueMap { // aka Dictionary or Map

	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	private LinkedList<String> keys;
	private LinkedList<Color> values;

	public KeyValueMap() {
		keys = new LinkedList<String>();
		values = new LinkedList<Color>();
	}

	public void add(String key, Color value) {
		keys.add(key);
		values.add(value);

	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		int index = keys.indexOf(key);

		if (index != -1) {
			return values.get(index);
		} else {
			return null;
		}
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		int index = keys.indexOf(key);
		if (index != -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		int index = keys.indexOf(key);
		if (index != -1) {
			keys.remove(index);
			values.remove(index);
		}
	}

}
