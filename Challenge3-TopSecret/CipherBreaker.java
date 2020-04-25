import java.util.Arrays;

//UIUC CS125 SPRING 2016 MP. File: CipherBreaker.java, CS125 Project: Challenge3-TopSecret, Version: 2016-02-15T07:51:07-0600.053978555
/**
 * See CipherBreaker.txt for instructions. TODO: add your netid to the line
 * below
 * 
 * @author fred-wu
 */
public class CipherBreaker {

	public static void main(String[] args) {
		int[] letterHistogram = new int[26];
//		for(int i=0; i<26;i++) {
//			letterHistogram[i]=0;
//		}

		int numDigits = 0;
		int numSpaces = 0;
		int numPunctuations = 0;

		TextIO.putln("Text?");
		String line = TextIO.getln();
		TextIO.putln(line);

		char[] chars = line.toUpperCase().toCharArray();

		for (char ch : chars) {
			if (ch >= 'A' && ch <= 'Z') {
				letterHistogram[ch - 'A'] += 1;
				continue;
			}
			if (ch >= '0' && ch <= '9')
				numDigits += 1;

			if (ch == '"' || ch == '-' || ch == '\'' || ch == '.' || ch == '!' || ch == ',') {
				numPunctuations += 1;
			}

			if (ch == ' ') {
				numSpaces += 1;
			}

		}

		for (int i = 0; i < 26; i++) {
			char out = (char) ('A' + i);
			int frqs = letterHistogram[i];
			if (frqs ==0) {
				continue;
			}
			System.out.printf("%s:%d\n", out, frqs);
		}
		if (numDigits >0)
			System.out.printf("DIGITS:%d\n", numDigits);
		if(numSpaces >0)
			System.out.printf("SPACES:%d\n", numSpaces);
		if(numPunctuations > 0)
			System.out.printf("PUNCTUATION:%d\n", numPunctuations);
	}
}
