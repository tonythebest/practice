package questions150;

import questions150.Q0104;
import junit.framework.TestCase;

public class Q0104Test extends TestCase {

	public void testFill20Percent() {
		
		String a = "a bc  dddd e ";
		String b = "a%20bc%20%20dddd%20e%20";
		
		assertEquals(b, Q0104.fill20Percent(a));
		System.out.println(a);
		
		
	}

}
