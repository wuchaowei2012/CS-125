
/**
 * @author fred-wu
 *
 */
//UIUC CS125 SPRING 2016 MP. File: LinkedList.java, CS125 Project: Challenge6-RecursionSee, Version: 2016-03-27T20:05:53-0500.183041871


import java.util.Arrays;

public class LinkedList {
	// Get and Set methods are NOT necessary!

	private LinkedList next;
	private final String word;

	/**
	 * Constructs this link.
	 * 
	 * @param word
	 *            ; a single word (never null).
	 * @param next
	 *            ; the next item in the chain (null, if there are no more
	 *            items).
	 */
	public LinkedList(String word, LinkedList next) {
		this.word = word;
		this.next = next;
	}

	public LinkedList(String word) {
		this.word = word;
		this.next = null;
	}

	/**
	 * Converts the entire linked list into a string representation.
	 */
	public String toString() {
		if (next == null)
			return word;// BASE CASE; no more recursion required

		// Recursive case:
		String restOfString = next.toString(); // Forward Recursion
		return word + ";" + restOfString;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * 
	 * @return number of entries.
	 */
	public int getCount() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.getCount(); // Forward recursion
	}

	/**
	 * Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * 
	 * @param word
	 * @return
	 */
	public static LinkedList helperfindlast(LinkedList itm) {
		if (itm.next == null)
			return itm;
		else
			return helperfindlast(itm.next);
	}

	public void append(String word) {
		LinkedList lst = helperfindlast(this);

		LinkedList node = new LinkedList(word, null);
		lst.next = node;
	}

	/**
	 * Recursively counts the total number of letters used.
	 * 
	 * @return total number of letters in the words of the linked list
	 */
	public int getLetterCount() {
		// returns the total number of letters. word1.length() +
		// word2.length()+...
		// "A" -> "CAT" -> null returns 1 + 3 = 4.
		if (next == null)
			return word.length(); // base case
		return word.length() + next.getLetterCount();
	}

	/**
	 * Recursively searches for and the returns the longest word.
	 * 
	 * @return the longest word i.e. word.length() is maximal.
	 */

	public String getLongestWord() {
		// recursive searches for the longest word
		// String longest = "";
		if (next == null) {
			return word;
		}

		if (word.length() < next.getLongestWord().length()) {
			return next.getLongestWord();
		} else {
			return word;
		}
	}

	/**
	 * Converts linked list into a sentence (a single string representation).
	 * Each word pair is separated by a space. A period (".") is appended after
	 * the last word. The last link represents the last word in the sentence.
	 */
	public String getSentence() {
		if (next == null)
			return word + '.';
		return this.word + " " + next.getSentence();
		// throw new IllegalArgumentException("Not Yet Implemented");
	}

	/**
	 * Converts linked list into a sentence (a single string representation).
	 * Each word pair is separated by a space. A period (".") is appended after
	 * the last word. The last link represents the first word in the sentence
	 * (and vice versa). The partialResult is the partial string constructed
	 * from earlier links. This partialResult is initially an empty string.
	 */
	public static String reverseHelper(LinkedList ll, String partialResult){
		if (ll.next == null && partialResult == ""){
			return ll.word;
		} 
		
		else if (ll.next == null && partialResult != ""){
			return ll.word+ " " + partialResult;
		} else{
			if (partialResult.equals("")){
				partialResult = ll.word;
			} else{
				partialResult = ll.word+ " " + partialResult;
			}
			
			return reverseHelper(ll.next , partialResult);
		}
		
	}
	public String getReversedSentence(String partialResult) {
//		throw new IllegalArgumentException("Not Yet Implemented");
		String rst = reverseHelper(this, partialResult);
		rst = rst + ".";
		System.out.println(rst);
		return rst;
	}

	// node 表示当前 header
	// 返回根据 words 创建的 list的 header
	static public LinkedList helper(String[] words) {

		if (words.length == 0) {
			return null;
		} else {
			LinkedList newNode = new LinkedList(words[0], null);
			newNode.next = helper(Arrays.copyOfRange(words, 1, words.length));
			return newNode;
		}
	}

	/**
	 * Creates a linked list of words from an array of strings. Each string in
	 * the array is a word.
	 */
	public static LinkedList createLinkedList(String[] words) {
		// Hint: This is a wrapper method. You'll need to create your
		// own recursive method.
		// Yes this is possible _without_ loops!

		return helper(words);
	}

	/**
	 * Searches for the following word in the linked list. Hint: use .equals not
	 * == to compare strings.
	 * 
	 * @param word
	 * @return true if the linked list contains the word (case sensivitive)
	 */
	public boolean contains(String word) {
		// throw new IllegalArgumentException("Not Yet Implemented");
		if (this.find(word) != null)
			return true;
		else
			return false;
	}

	/**
	 * Recursively searches for the given word in the linked list. If this link
	 * matches the given word then return this link. Otherwise search the next
	 * link. If no matching links are found return null.
	 * 
	 * @param word
	 *            the word to search for.
	 * @return The link that contains the search word.
	 */
	public LinkedList find(String word) {
		// throw new IllegalArgumentException("Not Yet Implemented");
		if (this.word != word && this.next == null) {
			return null;
		}
		if (this.word == word)
			return this;
		else
			return next.find(word);
	}

	/**
	 * Returns the last most link that has the given word, or returns null if
	 * the word cannot be found. Hint: Would forward recursion be useful?
	 * 
	 * @param word
	 *            the word to search for.
	 * @return the last LinkedList object that represents the given word, or
	 *         null if it is not found.
	 */
	public LinkedList findLast(String word) {
		// throw new IllegalArgumentException("Not Yet Implemented");
		if (this.next == null && !this.word.equals(word)) {
			return null;
		} else if (this.next == null && this.word.equals(word)) {
			return this;
		}

		if (next.findLast(word) != null) {
			return next.findLast(word);
		} else if (this.word == word) {
			return this;
		} else
			return null;
	}

	public LinkedList insert(String string) {

		// string.charAt(0)

		if (this.word.charAt(0) > string.charAt(0)) {
			LinkedList newNode = new LinkedList(string, null);
			newNode.next = this;
			return newNode;
		} else {
			LinkedList newNode = new LinkedList(string, null);
			
			LinkedList lst = helperfindlast(this);
			lst.next = newNode;
			return this;
		}
		

	}

}
