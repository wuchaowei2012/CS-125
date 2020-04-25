//UIUC CS125 SPRING 2016 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2016-02-15T07:51:07-0600.053978555
/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author fred-wu
 */
public class OddSum { 
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
 public static void main(String[] args) {
	 System.out.println("Max?");
	 int max = TextIO.getlnInt();
	 
	 int totalOdd = (max-1) /2 + 1 ;
	 String[] oddlist = new String[totalOdd];
	 String[] oddlist2 = new String[totalOdd];
	 
	 int sum = 0;
	 for(int i =0; i < totalOdd; i++) {
		 String.valueOf(2 * i + 1);
		 
		 oddlist[i] = String.valueOf(2 * i + 1);
		 sum += 2 * i + 1;
		 oddlist2[totalOdd - 1 - i] = String.valueOf(2 * i + 1);
	 }
	 
	 
	 System.out.println(String.join(" + ",  oddlist) + " = " + String.valueOf(sum)) ;
	 System.out.println(String.valueOf(sum)+ " = " + String.join(" + ",  oddlist2)) ;
	 

  } // end of main method
} // end of class 
