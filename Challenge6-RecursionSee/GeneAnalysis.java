//UIUC CS125 SPRING 2016 MP. File: GeneAnalysis.java, CS125 Project: Challenge6-RecursionSee, Version: 2016-03-27T20:05:53-0500.183041871
/**
 * @author ywang443
 *
 */
public class GeneAnalysis
{
	/** Wrapper method. Returns the length of the longest 
	 * common subsequence
	 */
	public static int score(String gene1, String gene2)
	{
		char c1[] = gene1.toCharArray();
		char c2[] = gene2.toCharArray();
		return score(c1, c2, c1.length-1, c2.length-1);
		// Hint: Use toCharArray() to convert each string to a char array.
		 // call your recursive implementation here with
		// the genes as char arrays, starting at the end of each gene.
	}

	/** Implements longest common subsequence recursive search
The recursive case is defined as
					S(i-1, j)
S(i,j) = max {		S(i,j-1)
					S(i-1,j-1)
					S(i-1,j-1) +1 if gene1[i] = gene2[j]

NB  0<=i < gene1.length
    0<=j < gene2.length

You need to figure out the base case.
	 * */
//	define a private recursive Class method 'score' that 
//	returns an integer the score.
//	The method should take four parameters- 
//	two char arrays and two integers (gene1,gene2,i,j)
//	i and j are the indices into gene1 and gene2 respectively.
	public static int score(char[] g1, char[] g2, int i, int j){
		if(i < 0 || j < 0)
			return 0;
		int s1 = 0, s2 = 0, s3 = 0, s4 = 0, max1 = 0, max2 = 0;
		if (g1[i] == g2[j])
			s4 += score(g1, g2, i-1, j-1) + 1;
		s1 += score(g1, g2, i-1, j);
		s2 += score(g1, g2, i, j-1);
		s3 += score(g1, g2, i-1, j-1);
		max1 = Math.max(s1, s2);
		max2 = Math.max(s3, s4);
		return Math.max(max1, max2);
	}

}
// Use local variables to store a recursive result so that you  do not need to calculate it again.

// Do not use a loops.
