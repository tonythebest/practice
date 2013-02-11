package org.practice.cracking.search;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class SearchTest extends TestCase {
	int[] randoms;
	
	public void setup(int n) {
		randoms = new int[n];
		for (int i = 0; i < n; i++) {
			randoms[i] = (int) (Math.random()*n);
		}
		System.out.println("Random Array: " + Arrays.toString(randoms));
	}
	
	public void testBinarySearch () {
//		setup(100);
//		int[] aa = Arrays.copyOf(randoms, randoms.length);
//		int[] bb = Arrays.copyOf(randoms, randoms.length);
//		Arrays.sort(aa);
//		System.out.println("Arrays.sort:  "+Arrays.toString(aa));
		
		int[] aa = {2, 3, 6, 6, 7, 7, 7, 8, 9, 9, 11, 11, 12, 13, 16, 16, 17, 18, 18, 18, 18, 20, 21, 22, 23, 23, 24, 25, 25, 26, 27, 28, 28, 29, 29, 30, 30, 32, 33, 34, 34, 34, 37, 38, 40, 42, 42, 43, 48, 49, 50, 52, 54, 56, 56, 58, 59, 60, 60, 61, 62, 62, 62, 63, 64, 64, 65, 66, 66, 70, 71, 72, 72, 73, 73, 74, 76, 78, 79, 80, 80, 81, 81, 83, 84, 84, 85, 85, 85, 85, 87, 87, 87, 88, 93, 96, 96, 97, 98, 99};
		System.out.println("Sorted 100 integers:  "+Arrays.toString(aa));
		
		int keyword = 30;
		int solution = Arrays.binarySearch(aa, keyword);
		System.out.println("Arrays.binarySearch: " + keyword + " is at "+solution);
		int location = Search.binarySearchIterative(aa, keyword);
		System.out.println("Search.binarySearchIterative: " + keyword + " is at "+location);
		assertEquals(solution, location);
		
		keyword = 24;
		solution = Arrays.binarySearch(aa, keyword);
		System.out.println("Arrays.binarySearch: " + keyword + " is at "+solution);
		location = Search.binarySearchIterative(aa, keyword);
		System.out.println("Search.binarySearchIterative: " + keyword + " is at "+location);
		assertEquals(solution, location);

		keyword = 99;
		solution = Arrays.binarySearch(aa, keyword);
		System.out.println("Arrays.binarySearch: " + keyword + " is at "+solution);
		location = Search.binarySearchIterative(aa, keyword);
		System.out.println("Search.binarySearchIterative: " + keyword + " is at "+location);
		assertEquals(solution, location);

		keyword = 1;
		solution = Arrays.binarySearch(aa, keyword);
		System.out.println("Arrays.binarySearch: " + keyword + " is at "+solution);
		location = Search.binarySearchIterative(aa, keyword);
		System.out.println("Search.binarySearchIterative: " + keyword + " is at "+location);
		assertEquals(solution, location);
		
		keyword = 100;
		solution = Arrays.binarySearch(aa, keyword);
		System.out.println("Arrays.binarySearch: " + keyword + " is at "+solution);
		location = Search.binarySearchIterative(aa, keyword);
		System.out.println("Search.binarySearchIterative: " + keyword + " is at "+location);
		//assertEquals(solution, location);
		
		int start = 0;
		int end = 100;
		
		int[] solutions = new int[end - start + 1];
		int[] locations = new int[end - start + 1];
		
		for (int i = start; i<=end; i++) {
			solutions[i] = Arrays.binarySearch(aa, i);
			locations[i] = Search.binarySearchIterative(aa, i);
			if (solutions[i]>=0) assertEquals(solutions[i], locations[i]);
		}
		System.out.println("Arrays.binarySearch         :  "+Arrays.toString(solutions));
		System.out.println("Search.binarySearchIterative:  "+Arrays.toString(locations));
		
		//assertTrue(Arrays.equals(solutions, locations));

		//remove repeated elements
		int numDistinct = 1;
		for (int i = 1; i<aa.length; i++) {
			if (aa[i]!=aa[i-1]) numDistinct++;
		}
		int[] bb = new int[numDistinct];
		int kk = 0;
		bb[kk] = aa[0];
		for (int i = 1; i<aa.length; i++) {
			if (aa[i]!=aa[i-1]) {
				kk++;
				bb[kk] = aa[i];
			}
		}
		
		System.out.println("Sorted "+numDistinct+" integers (repeated removed):  "+Arrays.toString(bb));

		for (int i = start; i<=end; i++) {
			solutions[i] = Arrays.binarySearch(bb, i);
			locations[i] = Search.binarySearchRecursive(bb, i);
			if (solutions[i]>=0) assertEquals(solutions[i], locations[i]);
		}
		System.out.println("Arrays.binarySearch         :  "+Arrays.toString(solutions));
		System.out.println("Search.binarySearchRecursive:  "+Arrays.toString(locations));
		
		
		
	}

}
