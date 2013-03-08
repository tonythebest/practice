package questions;

public class Q0101 {
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word));
		}
	}

	private static boolean isUniqueChars(String s) {
		// TODO Auto-generated method stub
		if (s.length()>256) return false;
		
		boolean[] ascii = new boolean[256];
		for (int i = 0; i < s.length(); i++) {
			if (ascii[s.getChar(i)]) return false;
			else ascii[s.getChar(i)] = true;
		}
		return true;
	}

	/**
	 * if String includes only a...z, we can use bit operation
	 * @param s input String
	 * @return unique or not
	 */
	private static boolean isUniqueChars2(String s) {
		// TODO Auto-generated method stub
		if (s.length() > 26) return false;
		int bits = 0;
		for (int i=0; i < s.length(); i++) {
			int shift = s.charAt(i) - 'a';
			if ((bits & (1 << shift)) > 0) return false;
			else bits |= 1 << shift;
		}
		return false;
	}

}
