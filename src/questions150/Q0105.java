package questions150;

public class Q0105 {

	public static String compression(String s) {
		
		char[] ss = s.toCharArray();
		int numDiffChars = 1;
		for (int i = 1; i < s.length(); i++) {
			if (ss[i]!= ss[i-1]) numDiffChars++;
		}
		int[] counters = new int[numDiffChars];
		char[] chars = new char[numDiffChars];
		int ind = 0;
		chars[ind] = ss[0];
		counters[ind] = 1;
		
		for (int i = 1; i < s.length(); i++) {
			if (ss[i]==ss[i-1]) counters[ind]++;
			else {
				ind++;
				chars[ind] = ss[i];
				counters[ind] = 1;
			}
		}
		
		String out = "";
		for (int i = 0; i < numDiffChars; i++) {
			out += chars[i] + "" + counters[i]; //this part is O(n^2)!!!
		}
		
		if (out.length()>=s.length()) return s;
		else return out;
	}
	
	//StringBuffer is much faster than String for appending String and chars!!!
	public static String compressionBuffer(String s) {
		
		char[] ss = s.toCharArray();
		int numDiffChars = 1;
		for (int i = 1; i < s.length(); i++) {
			if (ss[i]!= ss[i-1]) numDiffChars++;
		}
		int[] counters = new int[numDiffChars];
		char[] chars = new char[numDiffChars];
		int ind = 0;
		chars[ind] = ss[0];
		counters[ind] = 1;
		
		for (int i = 1; i < s.length(); i++) {
			if (ss[i]==ss[i-1]) counters[ind]++;
			else {
				ind++;
				chars[ind] = ss[i];
				counters[ind] = 1;
			}
		}
		
		StringBuffer out = new StringBuffer();
		for (int i = 0; i < numDiffChars; i++) {
			out.append(chars[i]);
			out.append(counters[i]);
		}
		
		if (out.length()>=s.length()) return s;
		else return out.toString();
	}

	/**
	 * Book has three solutions. Did not check the third one!!!
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
