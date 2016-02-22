//UIUC CS125 SPRING 2016 MP. File: CipherBreaker.java, CS125 Project: Challenge3-TopSecret, Version: 2016-02-15T07:51:07-0600.053978555
/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author ywang443
 */
public class CipherBreaker {

	public static void main(String[] args) {
		TextIO.putln("Text?");
		String line = TextIO.getln();
		TextIO.putln(line);
		int digits = 0;
		int space = 0;
		int punc = 0;
		int[] letterHistogram = new int[26];
		for(int i = 0; i < line.length(); i++){
			if((line.charAt(i) >=65 && line.charAt(i) <=90) || (line.charAt(i) >= 97 && line.charAt(i) <=122)){ // index
				if(line.charAt(i) >=65 && line.charAt(i) <=90) //capital letters
					letterHistogram[line.charAt(i) % 65]++;
				else
					letterHistogram[line.charAt(i) % 97]++;
			}
			else if(line.charAt(i) >= 48 && line.charAt(i) <= 57){ //digits
				digits++;
			}
			else if(line.charAt(i) == 32){ // space
				space++;
			}
			else if(line.charAt(i) == 33 || line.charAt(i) == 34 || line.charAt(i) == 39 || (line.charAt(i) >= 44 && line.charAt(i) <= 46)){
				punc++;
			}
			else{
				continue;
			}
		}
		for(int i = 0; i < 26; i++){
			if(letterHistogram[i] != 0){
				TextIO.putln((char)(i+65) + ":" + letterHistogram[i]);
			}
		}
		if(digits != 0)
			TextIO.putln("DIGITS:"+digits);
		if(space != 0)
			TextIO.putln("SPACES:"+space);
		if(punc != 0)
			TextIO.putln("PUNCTUATION:"+punc);
}	}
