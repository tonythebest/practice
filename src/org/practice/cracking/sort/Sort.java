package org.practice.cracking.sort;

import java.util.Arrays;

public class Sort {

	public static int[] sortTwoSortedArrays(int[] a, int[] b) {
	
		int[] c = new int[a.length+b.length];
		int aInd = 0;
		int bInd = 0;
		int cInd = 0;
		
		while (cInd < a.length + b.length) {
			if ( (aInd<a.length && bInd<b.length && a[aInd]<=b[bInd]) || (aInd < a.length && bInd >= b.length)) {
				c[cInd] = a[aInd];
				aInd++;
			} else {
				c[cInd] = b[bInd];
				bInd++;
			}
			cInd ++;
		}
		
		return c;
	}
	
	public static void sortTwoSortedPartsInPlace(int[] a, int low1, int high1, int low2, int high2, int[] nn) {
		//nn[] is for pass reference and keep track of computation complexity
		int numCells1 = high1 - low1 + 1; 
		int numCells2 = high2 - low2 + 1;
		int numCells = numCells1 + numCells2;
		int[] ss = new int[numCells];
		
		int ssIndex = 0;
		int index1 = low1;
		int index2 = low2;
		
		while (ssIndex < numCells) {
			nn[0]++;
			if ( (index1 <= high1 && index2 <= high2 && a[index1] <= a[index2]) || (index1 <= high1 && index2 > high2)) {
				ss[ssIndex] = a[index1];
				index1++;
			} else {
				ss[ssIndex] = a[index2];
				index2++;
			}
			ssIndex ++;
		}
		
		for (int i = low1; i <= high1; i++) {
			nn[0]++;
			a[i] = ss[i-low1];
		}
		
		for (int i = low2; i <= high2; i++) {
			nn[0]++;
			a[i] = ss[i-low2+numCells1];
		}
		
	}
	
	public static int[] mergeSort(int[] a) {
		// 
		int[] nn = new int[1];
		nn[0] = 0;
		divideSort(a, 0, a.length-1,nn);
		return nn;
	}
	
	public static void divideSort(int[] a, int low, int high, int[] nn) {
		
		if (low == high) return;
		
		int low1 = low;
		int high2 = high;
		int high1 = (high - low)/2 + low;
		int low2 = high1 + 1;
		
		divideSort(a, low1, high1, nn);
		divideSort(a, low2, high2, nn);
		sortTwoSortedPartsInPlace(a, low1, high1, low2, high2, nn);
		
	}

	public static int[] quickSort(int[] a) {
		// 
		int[] n = new int[1];
		n[0] = 0;
		quickSortDivide(a, 0, a.length-1, n);
		
		return n;
	}
	
	public static void quickSortDivide(int[] a, int low, int high, int[] n) {
		
//		System.out.println("low: "+low);
//		System.out.println("high: "+high);		
//		System.out.println(Arrays.toString(a));
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		if (low == high) return;
		int middleValue = a[low];
		int mid = low;
		int current = low+1;
		int right = high;
		while (current<=right) {
			n[0]++;
			if (a[current]<=middleValue) {
				int t = a[current];
				a[current] = a[mid];
				a[mid] = t;
				mid = current;
				current++;
			} else {
				int t = a[current];
				a[current] = a[right];
				a[right] = t;
				right--;
			}
		}
		
		if (low<mid-1) quickSortDivide(a, low, mid-1, n);
		if (mid+1<high) quickSortDivide(a, mid+1, high, n);
		
	}

	public static Integer radixSort(int[] a) {
		// 
		Integer n = 0;
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			n++;
			if (a[i] > max) max = a[i];
		}
		
		int tenBase = 1;
		
		while (max/tenBase > 0) {
			int[] bucket = new int[10];
			
			for (int i = 0; i < a.length; i++) {
				n++;
				bucket[a[i]/tenBase%10]++;
			}
			System.out.println("Max = " + max + "; bucket: "+Arrays.toString(bucket));
			
			for (int i = 1; i < 10; i++) {
				n++;
				bucket[i] += bucket[i-1];
			}
			System.out.println("Max = " + max + "; bucket: "+Arrays.toString(bucket));
			
			for (int i = 9; i > 0; i--) {
				n++;
				bucket[i] = bucket[i-1];
			}
			bucket[0] = 0;
			System.out.println("Max = " + max + "; bucket: "+Arrays.toString(bucket));
			
			int[] b = new int[a.length];
			for (int i = 0; i < a.length; i++) {
				n++;
				b[bucket[a[i]/tenBase%10]] = a[i];
				bucket[a[i]/tenBase%10]++; //move index of current digit more more place
			}
			
			for (int i = 0; i < a.length; i++) {
				n++;
				a[i] = b[i];
			}
			
			tenBase *= 10;
		}
		
		return n;
	}

	
	
	//public static void sortIntoTwoParts(int[] a, int low, int high)
	
}
