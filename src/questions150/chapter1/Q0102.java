package questions150.chapter1;

public class Q0102 {

	public static String reverse(String s) {
		// 
		int n = s.length();
		char[] c = s.toCharArray();
		System.out.println("length of String: "+n);
		System.out.println("length of Chars: "+c.length);
		for (int i = 0; i < n/2; i++) {
//			swap(c[i], c[n-i-1]);
//			System.out.println("i = "+i+": "+c[i]);
//			System.out.println("n-i-1 = "+i+": "+c[n-i-1]);
			char tmp = c[i];
			c[i] = c[n-i-1];
			c[n-i-1] = tmp;
		}
		return String.valueOf(c);
	}
	
//	public static void swap (Character a, Character b) { //swap function is not working
//		Character tmp = a;
//		a = b;
//		b = tmp;		
//	}
//	public static String reverse(String s) {
//		
//	}
	
}
