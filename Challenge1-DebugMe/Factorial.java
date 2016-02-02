//UIUC CS125 SPRING 2016 MP. File: Factorial.java, CS125 Project: Challenge1-DebugMe, Version: 2016-01-31T21:47:58-0600.331229973

/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author insert-your-netid-here
 */
public class Factorial {
	public static void main(String[] args) {
		int max = 0;
		long fact = 1;
		do{
			System.out.println("Enter a number between 1 and 20 inclusive.");	
			max = TextIO.getlnInt();
		} while(max < 1 || max >= 21);
			int counter = max;
			for( ; counter > 0; counter--){
				fact *= counter;
			}
		TextIO.putln(max + "! = " + fact);
	}
}
