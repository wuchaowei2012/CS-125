//UIUC CS125 SPRING 2016 MP. File: BinarySearch.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2016-04-18T08:00:20-0500.644631539
/*
 * @author fred_wu
 */
public class BinarySearch {
	/** Wrapper method. Just runs the recursive search method below for the entire array*/
	public static boolean search(int[] array, int key) {
		return search(array, key, 0, array.length - 1);
	}

	/**
	 * Recursive search using Divide and Conquer approach:
	 * The given array is already sorted so we can very quickly discover if the key is in the array or not.
	 * Hint: For the recursive case check the value at (lo+hi)/2
	 * and proceed accordingly.
	 */
	static boolean search(int[] array, int key, int lo, int hi) {
		//return false;
//		System.out.println("lo:" + String.valueOf(lo));
//		System.out.println("hi:" + String.valueOf(hi));
		if(hi < 0 || lo < 0){
			return false;
		}
		if(lo == hi && array[lo] != key){
			return false;
		}
		else if(key == array[(lo + hi) / 2]){
			return true;
		}
		else if (key < array[(lo + hi) / 2]){
			return search(array, key, lo, (lo + hi) / 2 - 1);
		} else{
			return search(array, key,  (lo + hi) / 2 + 1, hi);
		}
		
	}
}
