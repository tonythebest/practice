/**
 * from LeetCode.com
 * 
 * Palindrome Partitioning Feb 28 1118 / 4002
 * Given a string s, partition s such that every substring of the partition 
 * is a palindrome. Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
  
 * This is a classic DSF problem. it is very important and a little difficult.
 * 
 * Interesting part #1: find all substrings of a string, which are palindromes, 
 * by growing substrings both sides from single chars (always palindrome), 
 * which are substrings of odd number of chars, and growing substrings both 
 * sides from two chars (need to check if palindrome), which are substrings of 
 * even number of chars.
 * 
 * Interesting part #2: find a good data structure to store the indices of the
 * substrings of a string: two dimensional array. it is like a table of graph
 * 
 * Interesting part #3: run depth search first (DSF) and add substrings into
 * ArrayList<ArrayList<String>> a. need to create a temporary ArrayList<String> b,
 * add all substrings in one path and add the path of substrings into a; whenever
 * the pointer in the graph moves back, remove substrings from b behind the pointer
 * whenever the pointer moves forward in the graph, add new substrings into b
 * do not forget to clone b before adding into a, otherwise a will link to a bunch
 * of empty ArrayList<String>.
 * 
 * Interesting part #4: converting ArrayList<ArrayList<String>> a into Array[][].
 * the second dimension has different number of cells in each row; when using toArray,
 * the number of cells in each row must be specified by 
 * toArray(new String[a.get(i).size()])
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePartitioning {

	/**
	 * tell if a string is a palindrome or not this function is not used here
	 * 
	 * @param s
	 * @return
	 */
//	public boolean isPalindrome(String s) {
//		if (s == null || s == "")
//			return false;
//		if (s.length() == 1)
//			return true;
//		int i = 0, j = s.length() - 1;
//		while (i < j) {
//			if (s.charAt(i) != s.charAt(j))
//				return false;
//			i++;
//			j--;
//		}
//		return true;
//	}

	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int[][] p = palindromeIndices(s); // graph array to tell if a substring
											// is a palindrome or not; -1 = no;
											// 1 = yes; 0 = not checked
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		ArrayList<String> b = new ArrayList<String>(); // temporary for each
														// combination of
														// substrings
		dsf(s, p, 0, a, b); // recursive DSF function for search all path in
							// graph

		return a;
	}

	public void dsf(String s, int[][] p, int i, ArrayList<ArrayList<String>> a,
			ArrayList<String> b) {
		for (int k = i; k < s.length(); k++) {// check each substring after than
												// i
			if (p[i][k] == 1) {// if a substring is palindrome
				b.add(s.substring(i, k + 1)); // add palindrome into temporary
												// list
				// System.out.println(i + ", " + k + ", " + s.substring(i, k +
				// 1));
				dsf(s, p, k + 1, a, b); // go deeper before search neighbors
				if (k == s.length() - 1) { // at the end of the string s;
					ArrayList<String> c = new ArrayList<String>(b); // clone the
																	// temporary
																	// list
					a.add(c); // add cloned list into a
				}
				b.remove(b.size() - 1); // when moving backwards, remove the
										// substrings behind
			}
		}
	}

	/**
	 * find the indices of all substrings which are palindrome
	 * 
	 * @param s
	 * @return
	 */
	public int[][] palindromeIndices(String s) {
		if (s == null || s == "") { // if the string is empty, return null
			return null;
		}
		int[][] p = new int[s.length()][s.length()]; // create the output array
														// for palindromes
														// (yes/no), a graph

		for (int i = 0; i < s.length() - 1; i++) { // check all substrings for
													// single (except the last)
													// chars and two-char
			// odd number of chars
			p[i][i] = 1; // single chars are always palindrome
			int k = 1;
			// check all substrings with odd number of chars by growing on both
			// sides of single chars
			while (i - k >= 0 && i + k < s.length()) {// make sure the
														// substrings are within
														// the bounds of the
														// string
				if (s.charAt(i - k) != s.charAt(i + k)) {// if the chars on both
															// sides are not
															// equal
					p[i - k][i + k] = -1; // not a palindrome if not equal
					// no need to check the rest of substrings around a
					// non-palindrome
					while (i - k >= 0 && i + k < s.length()) {
						p[i - k][i + k] = -1;
						k++;
					}
					break;
				} else { // if the chars on both sides of a palindrome are equal
					p[i - k][i + k] = p[i - k + 1][i + k - 1]; // it is still a
																// palindrome
				}
				k++; // grow by one more char on both sides
			}

			// substrings with even number of chars
			if (s.charAt(i) == s.charAt(i + 1)) { // check two consecutive
													// chars, if they are equal
				p[i][i + 1] = 1; // the two-char substring is a palindrome
			} else { // if the two consecutive chars are not equal
				p[i][i + 1] = -1; // the two-char substring is not a palindrome
			}

			// grow like above for odd number of chars
			k = 1;
			while (i - k >= 0 && i + 1 + k < s.length()) {
				if (s.charAt(i - k) != s.charAt(i + 1 + k)) {
					p[i - k][i + 1 + k] = -1;
					// no need to check the rest of substring around a
					// non-palindrome
					while (i - k >= 0 && i + 1 + k < s.length()) {
						p[i - k][i + 1 + k] = -1;
						k++;
					}
					break;
				} else {
					p[i - k][i + 1 + k] = p[i - k + 1][i + 1 + k - 1];
				}
				k++;
			}

		}
		p[s.length() - 1][s.length() - 1] = 1; // substring as the last char

		return p;
	}

	/**
	 * this recursive function is incorrect
	 * 
	 * @param s
	 * @param p
	 * @param i
	 * @param j
	 */
//	public void detectAllPalindromes(String s, int[][] p, int i, int j) {
//		if (i + 1 >= j)
//			return;
//		if (p[i + 1][j - 1] == 0) {
//			detectAllPalindromes(s, p, i + 1, j - 1);
//		}
//		if (p[i + 1][j - 1] == -1) {
//			p[i][j] = -1;
//		} else if (s.charAt(i) == s.charAt(j)) {
//			p[i][j] = 1;
//		} else {
//			p[i][j] = -1;
//		}
//
//	}

	/**
	 * method to convert an ArrayList<ArrayList<String>> into a two dimensional
	 * array, the second dim size is dynamic
	 * 
	 * @param a
	 * @return
	 */
	public String[][] convertArrayListOfArrayListToStringArray(
			ArrayList<ArrayList<String>> a) {
		String[][] s = new String[a.size()][];
		for (int i = 0; i < a.size(); i++) {
			s[i] = (String[]) a.get(i).toArray(new String[a.get(i).size()]);
		}
		// int k = 0;
		// for (ArrayList<String> x : a) {
		// s[k] = x.toArray(new String[x.size()]);
		// k++;
		// }

		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) { // test
		// TODO Auto-generated method stub
		PalindromePartitioning x = new PalindromePartitioning();
		ArrayList<int[]> a = new ArrayList<int[]>();
		int[] b = new int[] { 1, 2 };
		int[] c = new int[] { 3, 4, 5 };
		a.add(b);
		a.add(c);

		// int[][] d = new int[a.size()][2];
		int[][] d = a.toArray(new int[a.size()][]);
		System.out.println(Arrays.deepToString(d));
		boolean[] e = new boolean[1];
		System.out.println(e[0]);

		int[] f = new int[1];
		System.out.println(f[0]);

		System.out.println(Arrays.deepToString(x.palindromeIndices("leet")));
		System.out.println(Arrays.deepToString(x.palindromeIndices("coder")));
		System.out.println(Arrays.deepToString(x.palindromeIndices("abbab")));

		ArrayList<ArrayList<String>> g = x.partition("abbab");
		System.out.println(Arrays.deepToString(x
				.convertArrayListOfArrayListToStringArray(g)));

	}

}
