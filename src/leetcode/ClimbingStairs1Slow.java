/** 
 * it is not a DP solution, so it is slow
 */
package leetcode;

public class ClimbingStairs1Slow {

    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
