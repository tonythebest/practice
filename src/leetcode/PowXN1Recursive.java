/**
 * recursive solution, not good for large n, stack overflow
 */
package leetcode;

public class PowXN1Recursive {

    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0.0 && n > 0) return 0.0;
        if (x == 0.0 && n <= 0) return 1.0; //wrong!
        if (n == 0) return 1.0;
        if (n > 0) return x*pow(x, n-1);
        if (n < 0) return 1/x*pow(x, n+1);
        return 0.0;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
