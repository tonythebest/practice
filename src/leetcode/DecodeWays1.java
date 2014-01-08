package leetcode;

/**
 * LeetCode
 * Decode Ways
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

 * solution by zingshow on June 26, 2013
 * two algorithms to solve this problem
 * 1. graph + depth-first search (DFS) + recursion (current code)
 * 2. dynamic programming (DP) (see next code)
 * algorithm 1:
 * 1) find all single or double chars which are valid encoding: 
 * like "1", "10" etc.
 * "0", "33" or "40" are not valid. 
 * record them in a graph data structure (like an array)
 * 2) use recursive (or non-recursive) way to traverse the graph by DFS, once
 * reach the last char, increment the counter by 1. if no any path exists,
 * return 0. 
 * comments: graph and recursive DFS has more time and space complexity.
 * do not use int for passing by reference; use array or class with int field
 * 
 */



public class DecodeWays1 {

    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.equals("")) return 0;
        char[] cc = s.toCharArray(); //conver to char array
        int n = s.length(); //number of chars
        boolean[] en1 = new boolean[n];
        boolean[] en2 = new boolean[n];
        for (int i = 0; i < n-1; i++) {
            if (cc[i] >= '1' && cc[i] <= '9') en1[i] = true;
            if (s.substring(i,i+2).compareTo("10") >= 0 
                    && s.substring(i,i+2).compareTo("26") <= 0) 
                en2[i] = true;
        }
        if (cc[n-1] >= '1' && cc[n-1] <= '9') {
            en1[n-1] = true;
            //return 10;
        }
        
//        System.out.println(Arrays.toString(en1));
//        System.out.println(Arrays.toString(en2));
        
        int[] numEn = {0}; 
        dsf(en1, en2, 0, numEn);        
        return numEn[0];
    }
    
    public void dsf(boolean[] en1, boolean[] en2, int start, int[] numEn) {
        int n = en1.length;
//        for (int i = start; i < n; i ++) {
        int i = start;
            if (en1[i]) {
                if (i == n-1) numEn[0]++;
                else dsf(en1, en2, i+1, numEn);
            }
            if (en2[i]) {
                if (i == n-2) numEn[0]++;
                else dsf(en1, en2, i+2, numEn);
            }
//        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays1 x = new DecodeWays1();
		System.out.println(x.numDecodings("30"));
		System.out.println(x.numDecodings("226"));
		System.out.println(x.numDecodings("1203040"));
		System.out.println(x.numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
		
	}

}
