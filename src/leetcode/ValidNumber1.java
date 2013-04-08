/**
 * 4/4/13 the solution does not cover all cases and is wrong
 */
package leetcode;

public class ValidNumber1 {

    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] C = s.toCharArray();
        int numE = 0, numDot = 0, numDash = 0;
        for (int i = 0; i < s.length(); i++) {
            if (C[i] == ' ') continue;
            else if (C[i] == 'e' || C[i] == 'E') {
                numE++;
                if (numE > 1) return false;
            } else if (C[i] == '.') {
                numDot++;
                if (numDot > 1) return false;
            } else if (C[i] == '-') {
                numDash++;
                if (numDash > 1) return false;
            } else if (C[i] < '0' || C[i] > '9') {
                return false;
            }
        }
        return true;        
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
