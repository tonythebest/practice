package org.practice.cracking.math;

import java.util.ArrayList;

import junit.framework.TestCase;

public class PrimalityTest extends TestCase {
	
	private Primality p1;
	private Primality p2;
	
	public void setup() {
		p1 = new Primality(10);
		p2 = new Primality(17);
	}
	
	public void testIsPrimeSimple () {
		setup();
		assertFalse("10 should not be a prime", Primality.isPrimeSimple(10));
		assertTrue("17 should be a prime", Primality.isPrimeSimple(17));	
	}
	
	public void testIsPrimeBetter () {
		for (int i = 2; i<10000; i++) {
			boolean simplePrime = Primality.isPrimeSimple(i);
			assertEquals(simplePrime, Primality.isPrimeBetter(i));
		}
	}
	
	public void testSoePrime () {
		ArrayList<Integer> primes = Primality.getSoePrimes(10000);
		for (int p : primes) {
			assertTrue(p+" should be a prime", Primality.isPrimeSimple(p));
		}
	}
	
	
	
}
