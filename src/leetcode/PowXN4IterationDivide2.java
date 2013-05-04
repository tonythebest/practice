/**
 * iteration solution, divide by 2, still slow
 */
package leetcode;

public class PowXN4IterationDivide2 {

    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0.0 && n > 0) return 0.0;
        if (x == 0.0 && n <= 0) return 1.0; //wrong!
        if (n == 0) return 1.0;
        
        double out = 1.0;
        int k = 1;
        if (n > 0) {
            while (n>0) {
                k = 2;
                double temp = x;
                while (k<n) {
                    temp = temp*temp;
                    k = k*2;
                }
                out = out*temp;
                k = k/2;
                n = n - k;
            }
        } else if (n < 0) {
            n=-n;
            while (n>0) {
                k = 2;
                double temp = 1/x;
                while (k<n) {
                    temp = temp*temp;
                    k = k*2;
                }
                out = out*temp;
                k = k/2;
                n = n - k;
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
