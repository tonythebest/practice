package leetcode;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null) return false;
        if (s.equals("")) return true;
        String sLow = s.toLowerCase();
        char[] S = sLow.toCharArray();
        int left = 0, right = s.length()-1;
        while (left < right) {
            while ((S[left] < '0' || S[left] > '9') && (S[left] < 'a' || S[left] > 'z') && (left < right)) {
                left++;
            }
            while ((S[right] < '0' || S[right] > '9') && (S[right] < 'a' || S[right] > 'z') && (left < right)) {
                right--;
            }
            if (S[left++] != S[right--]) return false; //do not forget increment and decrement
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
