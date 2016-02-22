//UIUC CS125 SPRING 2016 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2016-02-15T07:51:07-0600.053978555
/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author ywang443
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
	 TextIO.putln("Max?");
	 int max = 0;
	 String ret = "";
	 String rev = "";
	 int input = TextIO.getlnInt();
	 for(int i = 1; i <= input; i++){
		 if(i%2 == 1){
			 ret += i;
			 max += i;
		 }
		 if(i%2 == 0 && i != input)
			 ret += " + ";
	 }
	 ret = ret + " = " + max; 
	 rev = rev + max + " = ";
	 for(int i = input; i > 0; i--){
		 if(i%2 == 1){
			 rev += i;
			 max += i;
		 }
		 if(i%2 == 0 && i != input)
			 rev += " + ";
	 }
	 TextIO.putln(ret);
	 TextIO.putln(rev);
  } // end of main method
} // end of class 
