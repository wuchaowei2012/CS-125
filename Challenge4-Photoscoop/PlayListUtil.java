//UIUC CS125 SPRING 2016 MP. File: PlayListUtil.java, CS125 Project: Challenge4-Photoscoop, Version: 2016-02-22T08:07:56-0600.345149194
/**
 * Add you netid here..
 * @author ywang443
 *
 */
public class PlayListUtil {

	/**
	 * Debug ME! Use the unit tests to reverse engineer how this method should work.
	 * Hint: Fix the formatting (shift-cmd-F) to help debug the following code
	 * @param list
	 * @param maximum
	 */
	public static void list(String[] list, int maximum) {
		int i;
		for (i = 0; (maximum == -1 && i < list.length) || i < maximum; i++){ 
			TextIO.putln((i+1) + ". " + list[i]);
			}
	}

	/**
	 * Appends or prepends the title
	 * @param list
	 * @param title
	 * @param prepend if true, prepend the title otherwise append the title
	 * @return a new list with the title prepended or appended to the original list
	 */
	public static String[] add(String[] list, String title, boolean prepend) {
		String ret[] = new String[list.length + 1];
		if(prepend == true){
			ret[0] = title;
			for (int i = 1; i < list.length + 1; i++){
				ret[i] = list[i-1];
			}
		}
		else{
			for (int i = 0; i < list.length; i++){
				ret[i] = list[i];
			}
			ret[list.length] = title;
		}
		return ret;
	}
	/**
	 * Returns a new list with the element at index removed.
	 * @param list the original list
	 * @param index the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		String ret[] = new String[list.length - 1];
		int i;
		for(i = 0; i < index; i++){
			ret[i] = list[i];
		}
		for(i = index + 1; i < list.length; i++){
			ret[i - 1] = list[i];
		}
		return ret;
	}

}
