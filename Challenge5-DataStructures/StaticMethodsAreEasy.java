public class StaticMethodsAreEasy {
// Oh no... Someone removed  the methods but left the comments!!
// Hint: Get the Geocache class working and passing its tests first.

	/**
	 * Returns an array of num geocaches. Each geocache is initialized to a random
	 * (x,y) location.
	 * if num is less than zero, just return an empty array of length 0.
	 * 
	 * @param num
	 *            number of geocaches to create
	 * @return array of newly minted Points
	 */
//write the method here...
	public static Geocache[] createGeocaches(int k){
		if(k <= 0)
			k = 0;
		Geocache []ret = new Geocache[k];
		for(int i = 0; i < k; i++){
			ret[i] = new Geocache(Math.random()*10, Math.random()*10);
		}
		return ret;
	}

	/**
	 * Modifies geocaches if the geocache's X value is less than the allowable minimum
	 * value.
	 * 
	 * @param p
	 *            array of geocaches
	 * @param minX
	 *            minimum X value.
	 * @return number of modified geocaches (i.e. x values were too small).
	 */
	//write the method here...
	public static int ensureMinimumXValue(Geocache[] param, double minX){
		int modified = 0;
		for(int i = 0; i < param.length; i++){
			if(param[i].getX() < minX){
				param[i].setX(minX);
				modified++;
			}
		}
		return modified;
	}
	/**
	 * Counts the number of geocaches that are equal to the given geocache
	 * Hint: Use geocache.equals() method 
	 * @param p -
	 *            geocache array
	 * @param test -
	 *            test geocache (compared using .equal)
	 * @return number of matching geocaches
	 */
	//write the method here...
	public static int countEqual(Geocache[] param, Geocache test){
		int i = 0;
		int count = 0;
		while(i < param.length){
			if(param[i].equals(test))
				count++;
			i++;
		}
		return count;
	}
}
