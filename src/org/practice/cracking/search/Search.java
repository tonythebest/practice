package org.practice.cracking.search;

public class Search {

	public static int binarySearchIterative(int[] a, int keyword) {
		// 
		int low = 0;
		int high = a.length-1;
		int mid = 0;
				
		while (low < high) {
			mid = (high - low)/2+low;
			if (a[mid]==keyword) {
				return mid;
			} else if (a[mid]<keyword) {
				low = mid+1;
			} else {
				high = mid-1; //using mid is also correct! 
			}
		}
		
		if (keyword == a[low]) {
			return low;
		} else {
			return -low-1;
		}
		
	}

	public static int binarySearchRecursive(int[] a, int keyword) {
		
		int low = 0;
		int high = a.length-1;
		return recursive(a, keyword, low, high);
		
	}
	
	public static int recursive(int[] a, int keyword, int low, int high) {
		
		if (low >= high) {
			if (keyword == a[low]) {
				return low;
			} else {
				return -low-1;
			}
		}

//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("low = "+ low + ", high = "+high);

		int mid = (high - low)/2+low;
		if (a[mid]==keyword) {
			return mid;
		} else if (a[mid]<keyword) {
			return recursive(a, keyword, mid+1, high);
		} else {
			return recursive(a, keyword, low, mid); //using mid-1 is also correct! 
		}
		
	}

}
