package org.practice.cracking.sort;

import java.util.Arrays;

import junit.framework.TestCase;

public class SortTest extends TestCase {

	int[] randoms;
	
	public void setup(int n) {
		randoms = new int[n];
		for (int i = 0; i < n; i++) {
			randoms[i] = (int) (Math.random()*n/10);
		}
		System.out.println("Random Array: " + Arrays.toString(randoms));
	}
	
	public void testJavaSort() {
		int[] aa = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] bb = {5, 2, 9, 0, 4, 3, 1, 8, 7, 6};
		System.out.println("Input Array: " + Arrays.toString(bb));
		Arrays.sort(bb);
		System.out.println("Arrays.sort, tuned quicksort: "+Arrays.toString(bb));
		assertTrue(Arrays.equals(aa, bb));
	}
	
	public void testSortTwoSortedArrays() {
		int[] aa = {0, 1, 3, 7};
		int[] bb = {2, 3, 4, 5, 8, 9};
		int[] aabb = {0, 1, 2, 3, 3, 4, 5, 7, 8, 9};
		int[] cc = Sort.sortTwoSortedArrays(aa, bb);
		System.out.println("Sorted Array aa: "+Arrays.toString(aa));
		System.out.println("Sorted Array bb: "+Arrays.toString(bb));
		System.out.println("Sort Two Sorted Arrays: "+Arrays.toString(cc));
		assertTrue(Arrays.equals(aabb, cc));
	}
	
	public void testSortTwoSortedPartsInPlace () {
		int[] aa = {5, 0, 7, 9, 4, 1, 2, 3, 8, 6};
		int[] solution = {5, 0, 1, 2, 4, 3, 7, 8, 9, 6};
		System.out.println("Input Array: " + Arrays.toString(aa));
		Sort.sortTwoSortedPartsInPlace(aa, 1, 3, 5, 8, (new int[1]));
		System.out.println("Sort Two Sorted Parts: "+Arrays.toString(aa));
		assertTrue(Arrays.equals(solution, aa));
	}
	
	public void testMergeSort() {
		setup(1000);
		int[] aa = Arrays.copyOf(randoms, randoms.length);
		int[] bb = Arrays.copyOf(randoms, randoms.length);
		
		System.out.println("Input Array: " + Arrays.toString(aa));
		Arrays.sort(aa);
		System.out.println("Arrays.sort:  "+Arrays.toString(aa));
		
		System.out.println("Input Array: " + Arrays.toString(bb));
		int[] n = Sort.mergeSort(bb);
		System.out.println("Complexity: O(n) = " + n[0] + "; Merge Sorted: "+Arrays.toString(bb));
		assertTrue(Arrays.equals(aa, bb));
	}
	
	public void testQuickSort() {
		setup(1000);
		int[] aa = Arrays.copyOf(randoms, randoms.length);
		int[] bb = Arrays.copyOf(randoms, randoms.length);
		int[] cc = Arrays.copyOf(randoms, randoms.length);
		
		
		System.out.println();
		//System.out.println("Input Array: " + Arrays.toString(aa));
		Arrays.sort(aa);
		//System.out.println("Arrays.sort:  "+Arrays.toString(aa));
		
		System.out.println("Input Array: " + Arrays.toString(bb));
		int[] n = Sort.quickSort(bb);
		System.out.println("Complexity: O(n) = " + n[0] + "; Quick Sorted: "+Arrays.toString(bb));
		assertTrue(Arrays.equals(aa, bb));
		
		n = Sort.mergeSort(cc);
		System.out.println("Complexity: O(n) = " + n[0] + "; Merge Sorted: "+Arrays.toString(cc));
		assertTrue(Arrays.equals(aa, cc));
		
	}
	
	public void testRadixSort() {
		
		System.out.println();
		setup(1000);
		int[] aa = Arrays.copyOf(randoms, randoms.length);
		int[] bb = Arrays.copyOf(randoms, randoms.length);
		int[] cc = Arrays.copyOf(randoms, randoms.length);
		int[] dd = Arrays.copyOf(randoms, randoms.length);
		
		//System.out.println("Input Array: " + Arrays.toString(aa));
		Arrays.sort(aa);
		//System.out.println("Arrays.sort:  "+Arrays.toString(aa));
		
		//System.out.println("Input Array: " + Arrays.toString(bb));
		int[] n = Sort.quickSort(bb);
		System.out.println("Complexity: O(n) = " + n[0] + "; Quick Sorted: "+Arrays.toString(bb));
		assertTrue(Arrays.equals(aa, bb));
		
		n = Sort.mergeSort(cc);
		System.out.println("Complexity: O(n) = " + n[0] + "; Merge Sorted: "+Arrays.toString(cc));
		assertTrue(Arrays.equals(aa, cc));
		
		Integer m = Sort.radixSort(dd);
		System.out.println("Complexity: O(n) = " + m + "; Radix Sorted: "+Arrays.toString(dd));
		assertTrue(Arrays.equals(aa, dd));
		
//		int x = 0;
//		boolean y = false;
//		boolean[] z = new boolean[5];
//		System.out.println(x+", "+y+z);
	}
	
	
	
	
	
}
