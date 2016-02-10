//UIUC CS125 SPRING 2016 MP. File: MovieSurvey.java, CS125 Project: Challenge2-Hollywood, Version: 2016-02-08T21:35:43-0600.810632076
/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author ywang443
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		// TODO: Write your program here
		// Hints :
		// Formatted output
		// http://math.hws.edu/javanotes/c2/s4.html#basics.4.4
		
		// Don't just copy paste the expected output
		// For grading purposes your code may be tested
		// with other input values.
		int cinema, dvd, comp, total;
		double cinemaFrac, outsideFrac;
		TextIO.putln("Welcome. We're interested in how people are watching movies this year.");
		TextIO.putln("Thanks for your time. - The WRITERS GUILD OF AMERICA.");
		TextIO.putln("Please tell us about how you've watched movies in the last month.");
		TextIO.putln("How many movies have you seen at the cinema?");
		cinema = TextIO.getlnInt();
		TextIO.putln("How many movies have you seen using a DVD or VHS player?");
		dvd = TextIO.getlnInt();
		TextIO.putln("How many movies have you seen using a Computer?");
		comp = TextIO.getlnInt();
		total = cinema + dvd + comp;
		cinemaFrac = cinema / (double)total * 100;
		outsideFrac = (total-cinema)/(double)total * 100;
		TextIO.putln("Summary: " + cinema + " Cinema movies, " + dvd + " DVD/VHS movies, " + comp + " Computer movies");
		TextIO.putln("Total: " + total + " movies");
		TextIO.putf("Fraction of movies seen at a cinema: " + "%.2f" + "%%\n", cinemaFrac);
		TextIO.putf("Fraction of movies seen outside of a cinema: " + "%.2f" + "%%\n", outsideFrac);
	}
}
