package org.practice.cracking.dp;

import java.util.Arrays;

import junit.framework.TestCase;

public class FibonacciTest extends TestCase {
	
	public void testGetFibonacciRecursive() {
		int n = 40;
		System.out.println(Fibonacci.getFibonacciRecursive(n));
		assertEquals(102334155, Fibonacci.getFibonacciRecursive(n));
	}
	
	public void testGetFibonacciIterative() {
		int n = 40;
		for (int i = 0; i<= n; i++) {
			assertEquals(Fibonacci.getFibonacciRecursive(i), Fibonacci.getFibonacciIterative(i));
		}
	}
	
	public void testGetFibonacciDP () {
		int n = 80;
		Fibonacci fib = new Fibonacci(n);
		long[] fibs = fib.getFibs();
		System.out.println(Arrays.toString(fibs));
		for (int i = 0; i<= n; i++) {
			assertEquals(Fibonacci.getFibonacciIterative(i), fibs[i]);
		}		
	}
	

}
