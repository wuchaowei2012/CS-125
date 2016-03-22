/**
 * Prints out only lines that contain an email address Each printed line is
 * justified to right by prepending the text with '.' characters The minimum
 * width of the line including padding is 40 characters. See the test case for
 * example input and expected output.
 * @author ywang443
 */
class CallAStaticMethod {

	public static void main(String[] args) {

		while (!TextIO.eof())  {
			String line = TextIO.getln();
			// Use ExampleClassMethods
			// 'isEmailAddress' and 'createPadding' to complete this method
			if(line.indexOf(64) < 0 || line.indexOf(46) < 0)
				continue;
			//System.out.println(line.length());
			for(int i = 0; i < 40 - line.length(); i++){
				TextIO.put(".");
			}
			TextIO.putln(line);
		}
		
	}
}
