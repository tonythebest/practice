/**
 * iteration solution, divide by 2, still slow
 */
package leetcode;

public class PowXN5IterationDivide2LookUpTable {

    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0.0 && n > 0) return 0.0;
        if (x == 0.0 && n <= 0) return 1.0; //wrong!
        if (n == 0) return 1.0;
        
        double out = 1.0;
        int k = 1;
        int i = 1;
        
        while (k<n) {
            i++;
            k = k*2;
        }
        

        double[] XPow = new double[i+1];
        XPow[0] = 1.0;
        k = 2;
        i = 1;
        
        if (n > 0) {
            double temp = x;
            XPow[1] = temp;
            while (k<n) {
                temp = temp*temp;
                i++;
                XPow[i] = temp;
                k = k*2;
            }
            out = out*temp;
            k = k/2;
            n = n - k;
            
            while (n>0) {
                k = 2;
                i = 1;
                while (k<n) {
                    i++;
                    k = k*2;
                }
                
                out = out*XPow[i];
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
