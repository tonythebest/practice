/**
 * iteration solution: slow
 */
package leetcode;

public class PowXN2Iteration {

    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0.0 && n > 0) return 0.0;
        if (x == 0.0 && n <= 0) return 1.0; //wrong!
        if (n == 0) return 1.0;
        
        double out = 1.0;
        if (n > 0) {
            while (n>0) {
                out *= x;
                n--;
            }
        } else if (n < 0) {
            while (n<0) {
                out *= 1/x;
                n++;
            }
        }
        
        return out;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
