/**
 * @author ywang443
 */
import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map

	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	private String[] keys = new String[0];
	private Color[] color = new Color[0];
	private int size = 0;
	
	public void add(String key, Color value) {
		size++;
		String []temp = keys;
		keys = new String[size];
		keys[0] = key;
		for(int i = 1; i < keys.length; i++){
			keys[i] = temp[i-1];			
		}
		Color []temp2 = color;
		color = new Color[size];
		color[0] = value;
		for(int i = 1; i < color.length; i++){
			color[i] = temp2[i-1];			
		}		
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		for(int i = 0; i < size; i++){
			if(keys[i].equals(key)){
				return color[i];
			}
		}
		return null;
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		for(int i = 0; i < keys.length; i++){
			if(keys[i].equals(key)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		size--;
		String []temp = keys;
		keys = new String[size];
		int i = 0;
		for( ; i < temp.length; i++){
			if(!temp[i].equals(key)){
				keys[i] = temp[i];			
			}
			else{
				i++;
				break;
			}
		}
		for( ; i < temp.length; i++){
			keys[i-1] = temp[i];
		}
	}

}
