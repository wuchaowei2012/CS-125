//UIUC CS125 SPRING 2016 MP. File: MolecularSort.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2016-04-18T08:00:20-0500.644631539

/**
 * @author fred-wu
 */

public class MolecularSort {

	/** Sorts each xyz coordinate using it's Z value (coord[i][2] <= coord[j][2] for i<j). */
	static void sortCoordsByZ(double[][] coords) {
		// TODO: Implement this wrapper method.
		//All the work is performed by recursiveSort
		recursiveSort(coords, 0 , coords.length - 1);
		
	}

	/**
	 * recursively sorts coordinates entries by their z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static void recursiveSort(double[][] coords, int lo, int hi) {
		if(lo == hi){
			return;
		}
		int smallIndex = findIndexOfZMinimum(coords,lo, hi);
		swap(coords, lo, smallIndex);
		recursiveSort(coords, lo + 1,  hi);
	}

	/**
	 * returns the index of the entry with the lowest Z value. Entries between
	 * lo and hi inclusive are considered.
	 */
	static int findIndexOfZMinimum(double[][] coords, int lo, int hi) {
	
		if(lo == hi){return lo;}
		else if(coords[lo][2] < coords[findIndexOfZMinimum(coords,  lo + 1, hi)][2]){ return lo;}
		else { return findIndexOfZMinimum(coords,  lo + 1, hi);}
	}
	
	/* Swaps the (x,y and z) values of the i-th and j-th coordinates.*/
	static void swap(double[][] coords, int i, int j) {
		// TODO: write your swap implementation here
		double[] temp = coords[i];
		coords[i] = coords[j];
		coords[j] = temp;
	}
}
