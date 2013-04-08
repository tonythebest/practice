package org.practice.cracking.dp;

public class ClimbingStairs2DP1 {

    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0) return 0;
        int[] N = new int[n+1];
        return nWays(n,N);
        //return N[n];
        
    }
    
    public static int nWays(int n, int[] N) {
        if (n == 1) return N[1] = 1;
        if (n == 2) return N[2] = 2;
        if (N[n] > 0) return N[n];
        N[n] = nWays(n-1,N) + nWays(n-2,N);
        return N[n];
        
        //return N[n] = N[n-1]>0?N[n-1]:nWays(n-1,N) + N[n-2]>0?N[n-2]:nWays(n-2,N);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
