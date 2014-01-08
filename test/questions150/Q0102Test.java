package questions150;

import questions150.chapter1.Q0102;
import junit.framework.TestCase;

public class Q0102Test extends TestCase {
	
	public void testReverse() {
		String a = "abcdefg";
		String b = "gfedcba";
		
		assertEquals(b, Q0102.reverse(a));
		
		
	}
}
