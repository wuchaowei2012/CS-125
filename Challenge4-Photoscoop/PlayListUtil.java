//UIUC CS125 SPRING 2016 MP. File: PlayListUtil.java, CS125 Project: Challenge4-Photoscoop, Version: 2016-02-22T08:07:56-0600.345149194
/**
 * Add you netid here..
 * @author angrave
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
		if (maximum == -1){
			int index = 1;
			for (String str : list){
				TextIO.putln(   ""  + index + ". " + str);
				index +=1;
			}
		} else{
			for ( i = 0      ; i    <    maximum; i++) {      TextIO.putln(   ""  + (i+1) + ". " + list[i]);}
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
		String[] newlist = new String[list.length + 1];
		if (prepend){
			newlist[0] = title;
			for (int i =0; i< list.length; i ++){
				newlist[i + 1] = list[i];
			}
		
		}
		else{
			for (int i =0; i < list.length; i ++){
				newlist[i] = list[i] ;
			}
			newlist[list.length] = title;
		}
		return newlist;
	}
	
	/**
	 * Returns a new list with the element at index removed.
	 * @param list the original list
	 * @param index the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		String[] newlist = new String[list.length - 1];
		int id = 0;
		for (int i =0; i < list.length; i ++){
			if(i == index){
				continue;
			}
			
			newlist[id] = list[i];
			id +=1;
			
		}
		
		return newlist;
	}

}
