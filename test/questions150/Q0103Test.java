package questions150;

import questions150.Q0103;
import junit.framework.TestCase;

public class Q0103Test extends TestCase {
	
	public void testPermutation() {
		String a = "abddefg";
		String b = "gfedbda";
		String c = "abcdghk";
		
		assertTrue(Q0103.permutation(a,b));
		assertFalse(Q0103.permutation(a,c));
		
		
	}
	
}
