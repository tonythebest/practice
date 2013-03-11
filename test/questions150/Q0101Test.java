package questions150;

import questions150.Q0101;
import junit.framework.TestCase;

public class Q0101Test extends TestCase {

	public void testIsUnique() {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		boolean[] unique = {true, false, false, true, true};
		
		for (int i = 0; i< words.length; i++) {
			assertEquals(Q0101.isUniqueChars(words[i]), unique[i]);
			assertEquals(Q0101.isUniqueChars2(words[i]), unique[i]);
		}
		
	}
}

