package org.practice.cracking.math;

import java.util.ArrayList;
import java.util.Arrays;

public class Primality {

	private int p;
	
	public Primality(int i) {
		this.p = i;
	}

	public static boolean isPrimeSimple(int n) {
		// 
		if (n<2) return false;
		for (int i = 2; i < n; i++) {
			if (n%i == 0) return false;
		}
		return true;
	}

	public static boolean isPrimeBetter(int n) {
		// 
		if (n < 2) return false;
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n%i == 0) return false;
		}
		return true;
	}

	public static ArrayList<Integer> getSoePrimes(int n) {
		// 
		boolean[] isPrimes = new boolean[n+1];
		for (int i = 0; i<=n; i++) {
			isPrimes[i] = true;
		}
		
		isPrimes[0] = false;
		isPrimes[1] = false;
		
		for (int i = 2; i<= Math.sqrt(n); i++) {
			if (!isPrimes[i]) continue;
			int k = 2;
			while (k*i<=n) {
				isPrimes[k*i] = false;
				k++;
			}
		}
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i<=n; i++) {
			if (isPrimes[i]) primes.add(i);
		}
		
		//System.out.println(Arrays.toString(isPrimes));
		System.out.println(primes);
		
		return primes;
	}
	
	

}
