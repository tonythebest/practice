package leetcode;

public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) return 0; //missed this line first time!!!
        int prev = 0;
        int next = 1;
        while (next < A.length) {
            if (A[prev] == A[next]) next++;
            else {
                prev++;
                A[prev] = A[next];
                next++;
            }
        }
        return prev+1;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
