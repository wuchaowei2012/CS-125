
/**
 * Complete the class method 'analyze' that takes a SimplePublicPair object as an argument
 * and returns a new SimplePublicTriple object.
 * The SimplePublicTriple needs to set up as follows:
 * x = the minimum value of 'a' and 'b'
 * y = the maximum value of 'a' and 'b'
 * description:a*b=M 
 *   where a,b, and M are replaced with the numerical values of a, b and the multiplication of a and b.
 * Your code will create a SimplePublicTriple, initializes the three fields and return a reference to the SimplePublicTriple object.
 *@author ywang443
 */
public class UsingPublicFieldsIsEasy {
	
	public static SimplePublicTriple analyze(SimplePublicPair in) {
		SimplePublicTriple ret = new SimplePublicTriple();
		if(in.a < in.b){
			ret.x = in.a;
			ret.y = in.b;
		}
		else{
			ret.x = in.b;
			ret.y = in.a;
		}
		ret.description = in.a + "*" + in.b + "=" + in.a*in.b;
		return ret;
	}

}
