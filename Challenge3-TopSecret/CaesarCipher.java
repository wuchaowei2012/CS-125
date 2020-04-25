//UIUC CS125 SPRING 2016 MP. File: CaesarCipher.java, CS125 Project: Challenge3-TopSecret, Version: 2016-02-15T07:51:07-0600.053978555
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt Hints: line.charAt( int ) is useful. You'll need loops, and
 * conditions and variables You'll need to read the Test cases to understand how
 * your program should work. Good Programming Hints:
 * "DRY: Don't Repeat Yourself" Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * 
 * @author fred-wu
 */

// Please enter the shift value (between -25..-1 and 1..25)
// 0 is not a valid shift value.
// Please enter the shift value (between -25..-1 and 1..25)
// 26 is not a valid shift value.
// Please enter the shift value (between -25..-1 and 1..25)
// Using shift value of 3
// Please enter the source text (empty line to quit)
// Source :ABCD EFGHIJKLMNOPQRSTUVWXYZ!
// Processed:DEFG HIJKLMNOPQRSTUVWXYZABC!
// Please enter the source text (empty line to quit)
// Bye.

// + An incomplete list of Java methods, expressions and operators that may be
// useful:
// String methods:
// s.charAt(i); s.length(); result += c; // where c is a char
// Char expressions:
// c >='A' c>='a' c + 26 c - 'a'
// Boolean and modulus operators
// ! && || % == !=

public class CaesarCipher {

	public static String process(String input, int shift) {
		char[] chars = input.toUpperCase().toCharArray();
		String stroutput = "";
		if (shift < 0) {
			shift = shift % 26;
			shift += 26;
		}
		for (char ch : chars) {
			char tag;
			if (ch > 'Z' || ch < 'A') {
				tag = ch;
			} else {
				if (ch + shift <= 'Z') {
					tag = (char) (ch + shift);
				} else {
					int charshift = (ch + shift - 'Z' - 1) % 26;
					tag = (char) ('A' + charshift);
				}
			}
			stroutput += tag;
		}
		return stroutput;
	}

	public static String process2(String input, int signal) {
		String stroutput = "";
		input = input.toUpperCase();
		stroutput = stroutput + input.charAt(0);
		for (int i = 1; i < input.length(); i++) {
			stroutput = stroutput + process(String.valueOf(input.charAt(i)), i * signal / 999);
		}

		return stroutput;
	}

	public static void main(String[] strings) {
		// TODO: Delete the following line and write your implementation here-
		// throw new RuntimeException ("Et tu Brutus?");

		boolean isshift = true;
		int shift = 0;
		while (isshift) { // if odd keep rolling the dice
			System.out.println("Please enter the shift value (between -25..-1 and 1..25)");
			shift = TextIO.getlnInt();
			if (shift > -25 && shift < 25 && shift != 0) {
				isshift = false;
				System.out.printf("Using shift value of %d\n", shift);
			
			} else if(shift == 999 || shift == -999) {
				isshift = false;
				System.out.printf("Using position shift\n", shift);

			} else{
				System.out.printf("%d is not a valid shift value.\n", shift);
				continue;
			}

			// code to change keepLooping e.g. isOdd = dice % 2 == 1;

		}

		if (shift != 999 && shift != -999) {

			boolean isprocess = true;
			while (isprocess) {

				System.out.println("Please enter the source text (empty line to quit)");
				String strInput = TextIO.getlnString();
				if ("".equals(strInput.trim())) {
					System.out.println("Bye.");
					return;
				}

				String stroutput = process(strInput, shift);
				System.out.printf("Source   :%s\n", strInput);
				System.out.printf("Processed:%s\n", stroutput);

			}
		} else {

			boolean isprocess = true;
			while (isprocess) {

				System.out.println("Please enter the source text (empty line to quit)");
				String strInput = TextIO.getlnString();
				if ("".equals(strInput.trim())) {
					System.out.println("Bye.");
					return;
				}
				int signal = shift;
				String stroutput = process2(strInput, signal);
				System.out.printf("Source   :%s\n", strInput);
				System.out.printf("Processed:%s\n", stroutput);
			}

		}

	}
}
