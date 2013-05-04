/**
 * recursive solution, divide by 2, use r to represent pow(x,n/2)
 * save half time, much better than PowXN3RecursiveDivide2
 */
package leetcode;

public class PowXN6RecursiveDivide2 {

    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0.0 && n > 0) return 0.0;
        if (x == 0.0 && n <= 0) return 1.0; //wrong!
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        double r = pow(x, n/2);
        return r*r*pow(x,n%2);
    }

    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
