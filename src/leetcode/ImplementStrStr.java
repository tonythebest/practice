/**
 * this is a brutal force way, but passed the test
 */
package leetcode;

public class ImplementStrStr {

    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (haystack == null) return null;
        if (needle == null) return null;
        
        if (haystack.equals("") && needle.equals("")) return "";
        if (haystack.equals("")) return null;
        if (needle.equals("")) return haystack;
        
        String out = null;
    	char[] h = haystack.toCharArray();
		char[] n = needle.toCharArray();
    	int i = 0, j = 0;
		boolean match = false;
        
    	for (i = 0; i <= h.length - n.length; i++) {
			match = true;
			for (j = 0; j < n.length; j++) {
				if (h[i + j] != n[j]) {
					match = false;
					break;
				}
			}
			if (match == true)
				break;
		}

    	if (match == true) {
			out = haystack.substring(i);
		}
        
        return out;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementStrStr x = new ImplementStrStr();
		System.out.println(x.strStr("aaa", "a"));

	}

}
