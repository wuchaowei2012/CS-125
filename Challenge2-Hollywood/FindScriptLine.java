//UIUC CS125 SPRING 2016 MP. File: FindScriptLine.java, CS125 Project: Challenge2-Hollywood, Version: 2016-02-08T21:35:43-0600.810632076
/**
 * A program to search for specific lines and print their line number. See
 * FindScriptLine.txt for more details TODO: add your netid to the line below
 * 
 * @author fred-wu
 */
public class FindScriptLine {

	public static void main(String[] args) {
		// TODO: Implement the functionality described in FindScriptLine.txt
		// TODO: Test your code manually and using the automated unit tests in
		// FindScriptLineTest
		boolean output = false; // Set to true when we find the desired
								// character

		System.out.println("Please enter the word(s) to search for");
		String keyword = TextIO.getln();

		System.out.printf("Searching for '%s'\n", keyword);

		TextIO.readFile("thematrix.txt"); // stop reading from the keyboard- use
											// the script

		// This loop will read one line at a time from the script until it
		// reaches the end of the file and then TextIO.eof() will return true.
		// eof means end-of-file
		int line_index = 0;
		while (false == TextIO.eof()) {
			line_index += 1;
			String line = TextIO.getln(); // Read the next line

			// TODO: If it's a blank line set 'output' to false
			// TODO: Correct the output format (see ScriptPrinter.txt example
			// output)
			// TODO: Re-order the three if statements so the output is correct
			if (line.toLowerCase().contains(keyword.toLowerCase())) {
				System.out.printf("%d - %s\n", line_index, line.trim());
			}
		}
		// TODO: Print 3 dashes here to indicate processing is complete
		System.out.printf("Done Searching for '%s'\n", keyword);

	}
}
