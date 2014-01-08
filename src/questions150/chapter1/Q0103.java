package questions150.chapter1;

public class Q0103 {

	public static boolean permutation(String a, String b) {
		// TODO Auto-generated method stub
		if (a.length() != b.length()) return false;
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		
		int[] mm = new int[256];
		int[] nn = new int[256];
		
		for (int i = 0; i < a.length(); i++) {
			mm[aa[i]]++;
			nn[bb[i]]++;
		}
		
		for (int i = 0; i < 256; i++) {
			if (mm[i] != nn[i]) return false;
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
