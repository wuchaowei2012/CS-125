//UIUC CS125 SPRING 2016 MP. File: GeneAnalysis.java, CS125 Project: Challenge6-RecursionSee, Version: 2016-03-27T20:05:53-0500.183041871
/**
 * @author fred-wu
 *
 */

import java.lang.Math;

public class GeneAnalysis {
	/**
	 * Wrapper method. Returns the length of the longest common subsequence
	 */
	private static boolean helper(String gene1, String gene2, int i, int j) {
		if (gene1.charAt(i) == gene2.charAt(j)) {
			return true;
		}

		return false;
	}

	public static int score(String gene1, String gene2) {
		// throw new IllegalArgumentException("Not Yet Implemented");
		// Hint: Use toCharArray() to convert each string to a char array.
		// call your recursive implementation here with
		// the genes as char arrays, starting at the end of each gene.
		
		// assertEquals(2, GeneAnalysis.score("ACGT","AC")); 
		if (gene1.length() == 0 || gene2.length() == 0 || gene1 == null || gene2 == null) {
			return 0;
		} else {
			if (gene1 == null || gene1.length() == 0){
				return 0;
			}
			if(gene2 == null || gene2.length() == 0){
				return 0;
			}
			String genea = gene1.substring(1);
			String geneb = gene1.substring(1);
			if (helper(gene1, gene2, 0, 0)){
				return Math.max(Math.max(score(genea, gene2), score(gene1, geneb)), 1 + score(genea, geneb));
			} else{
				return Math.max(score(genea, gene2), score(gene1, geneb));
			}
		}
	}

	/**
	 * Implements longest common subsequence recursive search The recursive case
	 * is defined as S(i-1, j) S(i,j) = max { S(i,j-1) S(i-1,j-1) S(i-1,j-1) +1
	 * if gene1[i] = gene2[j]
	 * 
	 * NB 0<=i < gene1.length 0<=j < gene2.length
	 * 
	 * You need to figure out the base case.
	 */
	// define a private recursive Class method 'score' that
	// returns an integer the score.
	// The method should take four parameters-
	// two char arrays and two integers (gene1,gene2,i,j)
	// i and j are the indices into gene1 and gene2 respectively.

}
// Use local variables to store a recursive result so that you do not need to
// calculate it again.

// Do not use a loops.
