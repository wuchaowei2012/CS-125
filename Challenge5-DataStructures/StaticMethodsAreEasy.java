/**
 * @author fred wu
 *
 */

public class StaticMethodsAreEasy {

	// Oh no... Someone removed the methods but left the comments!!
	// Hint: Get the Geocache class working and passing its tests first.

	/**
	 * Returns an array of num geocaches. Each geocache is initialized to a
	 * random (x,y) location. if num is less than zero, just return an empty
	 * array of length 0.
	 * 
	 * @param num
	 *            number of geocaches to create
	 * @return array of newly minted Points
	 */
	// write the method here...
	
	public StaticMethodsAreEasy(){
		
	}

	public static Geocache[] createGeocaches(int i) {
		Geocache[] geocache;
		if (i <= 0) {
			geocache = new Geocache[0];
		} else {
			geocache = new Geocache[i];
			for(int j=0; j< i;j++){
				geocache[j] = new Geocache(0,0);
			}
		}

		return geocache;
	}

	/**
	 * Modifies geocaches if the geocache's X value is less than the allowable
	 * minimum value.
	 * 
	 * @param p
	 *            array of geocaches
	 * @param minX
	 *            minimum X value.
	 * @return number of modified geocaches (i.e. x values were too small).
	 */
	// write the method here...

	public static int ensureMinimumXValue(Geocache[] pts, double value) {
		int t = pts.length;
		int rst = 0;
		for (int i = 0; i < t; i++) {
			if (pts[i].getX() < value) {
				pts[i].setX(value);
				rst += 1;
			}
		}

		return rst;
	}

	/**
	 * Counts the number of geocaches that are equal to the given geocache Hint:
	 * Use geocache.equals() method
	 * 
	 * @param p
	 *            - geocache array
	 * @param test
	 *            - test geocache (compared using .equal)
	 * @return number of matching geocaches
	 */
	// write the method here...

	public static int countEqual(Geocache[] pts, Geocache origin) {
		int rst = 0;
		for (Geocache pt : pts) {
			if (pt.equals(origin)) {
				rst += 1;
			}
		}
		return rst;
	}
}
