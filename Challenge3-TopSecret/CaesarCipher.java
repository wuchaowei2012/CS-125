//UIUC CS125 SPRING 2016 MP. File: CaesarCipher.java, CS125 Project: Challenge3-TopSecret, Version: 2016-02-15T07:51:07-0600.053978555
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author ywang443
 */
public class CaesarCipher {

	public static void main(String[] strings) {
		//TODO: Delete the following line and write your implementation here- 
		//int shiftNum;
		TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
		int shiftNum = TextIO.getlnInt();
		while((shiftNum < -25 || shiftNum > 25 || shiftNum == 0) && !TextIO.eof()){
			TextIO.putln(shiftNum + " is not a valid shift value.");
			TextIO.putln("Please enter the shift value (between -25..-1 and 1..25)");
			shiftNum = TextIO.getlnInt();
		}		
		TextIO.putln("Using shift value of " + shiftNum);
		while(true){
			String line = "";
			StringBuilder ret = new StringBuilder();
			TextIO.putln("Please enter the source text (empty line to quit)");
			line = TextIO.getln();
			if(line.isEmpty()){
				TextIO.putln("Bye.");
				break;
			}
			TextIO.put("Source   :");
			TextIO.putln(line);
			line = line.toUpperCase();
			for(int i = 0; i < line.length(); i++){
				if(line.charAt(i)>='A' && line.charAt(i)<='Z'){
					char c = (char) (line.charAt(i) + shiftNum);
					if (c > 'Z')
						ret.append((char)(line.charAt(i) - (26-shiftNum)));
					else if(c < 'A')
						ret.append((char)(line.charAt(i) + (26+shiftNum)));
					else
						ret.append(c);
				}
				else{
					ret.append(line.charAt(i));
				}
			}
			TextIO.put("Processed:" + ret + "\n");
		}
	}

}
