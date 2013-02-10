package org.practice.cracking.dp;

public class Fibonacci {
	
	private long[] fibs;
	
	public Fibonacci(int n) {
		fibs = new long[n+1];
		for (int i = 0; i<=n; i++) {
			fibs[i] = 0;
		}
		getFibonacciDP(n);
	}

	public static long getFibonacciRecursive(int i) {
		// 
		if (i == 0) return 0;
		if (i == 1) return 1;
		return getFibonacciRecursive(i-2) + getFibonacciRecursive(i-1);
		
	}

	public static long getFibonacciIterative(int n) {
		// 
		
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		long a = 0;
		long b = 1;
		
		for (int i=2; i<=n; i++) {
			long t = b;
			b = a + b;
			a = t;
		}
		return b;
	}

	public long getFibonacciDP(int i) {
		// 
		if (i==0) {
			fibs[0] = 0;
			return 0;
		}
		if (i==1) {
			fibs[1] = 1;
			return 1;
		}
		
		if (fibs[i]>0) return fibs[i];
		
		fibs[i] = getFibonacciDP(i-1) + getFibonacciDP(i-2);
		
		return fibs[i];
	}
	
	public long[] getFibs() {
		return fibs;
	}
	
	
	

}
