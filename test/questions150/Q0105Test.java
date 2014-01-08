package questions150;

import questions150.chapter1.Q0105;
import junit.framework.TestCase;

public class Q0105Test extends TestCase {

	public void testCompression() {
		
		String a = "aabccccccccccccaaa";
		String b = "a2b1c12a3";
		String aOut = Q0105.compression(a);
		System.out.println(aOut);
		assertEquals(b, aOut);
		
		String c = "abcca";
		String cOut = Q0105.compression(c);
		System.out.println(cOut);
		assertEquals(c, cOut);
		
		String aBufferOut = Q0105.compressionBuffer(a);
		System.out.println(aBufferOut);
		assertEquals(b, aBufferOut);
		
		String cBufferOut = Q0105.compressionBuffer(c);
		System.out.println(cBufferOut);
		assertEquals(c, cBufferOut);
		
		
	}

}
