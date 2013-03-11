package leetcode;

import java.util.Arrays;

public class TwoSum {

	/**
	 * The simple way is to check elements pair one by one, O(n^2); 
	 * We can sort array first O(nlgn), 
	 * pick the first element from small to large, 
	 * binary search (sum - first) (O(nlgn)).
	 * find indices in the original array
	 * @param N
	 * @param t
	 * @return
	 */
    public int[] twoSum(int[] N, int t) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (N == null || N.length == 0) return null;
        int[] M = Arrays.copyOf(N, N.length); //memorize it!!!
        Arrays.sort(M); //memorize it!!!
        int a = 0, b = 0;
        for (int i = 0; i< M.length - 1; i++) {
            a = M[i];
            b = t - a;
            if (Arrays.binarySearch(M, i+1, M.length, b) > 0) break;
        }
        int[] Index = {-1, -1};
        int indOfIndex = 0, i = -1; //single variables must be initialized before using!!!
        boolean aFound = false, bFound = false; //single variables must be initialized before using!!!
        while (indOfIndex < 2) {
            i++;
            if (!aFound && a == N[i]) {
                Index[indOfIndex++] = i+1;
                aFound = true;
            } else if (!bFound && b == N[i]) {
                Index[indOfIndex++] = i+1;
                bFound = true;
            }
        }
        return Index;

        
    }	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
