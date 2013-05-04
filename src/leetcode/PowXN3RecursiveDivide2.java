/**
 * recursive solution, divide by 2, still slow
 */
package leetcode;

public class PowXN3RecursiveDivide2 {

    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0.0 && n > 0) return 0.0;
        if (x == 0.0 && n <= 0) return 1.0; //wrong!
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        if (n > 0) return pow(x, n/2)*pow(x, n/2)*pow(x,n%2);
        if (n < 0) return pow(x, n/2)*pow(x, n/2)*pow(x,n%2);
        return 0.0;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
