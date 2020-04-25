/**
 * @author fred wu
 *
 */

/**
 * Complete the class method 'analyze' that takes a SimplePublicPair object as
 * an argument and returns a new SimplePublicTriple object. The
 * SimplePublicTriple needs to set up as follows: x = the minimum value of 'a'
 * and 'b' y = the maximum value of 'a' and 'b' description:a*b=M where a,b, and
 * M are replaced with the numerical values of a, b and the multiplication of a
 * and b. Your code will create a SimplePublicTriple, initializes the three
 * fields and return a reference to the SimplePublicTriple object.
 *
 */
public class UsingPublicFieldsIsEasy {

	public static SimplePublicTriple analyze(SimplePublicPair in) {
		// return null;
		int a = in.a;
		int b = in.b;

		int x, y;

		if (a > b) {
			x = b;
			y = a;
		} else {
			x = a;
			y = b;
		}
		SimplePublicTriple rst = new SimplePublicTriple();
		rst.x = x;
		rst.y = y;
		rst.description = String.valueOf(a) + "*" + String.valueOf(b) + "=" + String.valueOf(a*b);
		return rst;
	}
}
