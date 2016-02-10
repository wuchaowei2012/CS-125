//UIUC CS125 SPRING 2016 MP. File: FindScriptLine.java, CS125 Project: Challenge2-Hollywood, Version: 2016-02-08T21:35:43-0600.810632076
/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author ywang443
 */
public class FindScriptLine {

	public static void main(String[] args) {
// TODO: Implement the functionality described in FindScriptLine.txt
// TODO: Test your code manually and using the automated unit tests in FindScriptLineTest		
		boolean output=false;
		String word="";
		int lineNum = 0;
		TextIO.putln("Please enter the word(s) to search for");
		word = TextIO.getln();
		TextIO.putln("Searching for '" + word + "'");
		TextIO.readFile("thematrix.txt");
		while(!TextIO.eof()){
			lineNum++;
			String line = TextIO.getln();
			if(line.toLowerCase().contains(word.toLowerCase()))
				output = true;
			
			if(output)
				TextIO.putln(lineNum + " - " + line.trim());
			
			output = false;
		}
		TextIO.putln("Done Searching for '" + word + "'");
	}
}
