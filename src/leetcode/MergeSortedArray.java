package leetcode;

public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int a = m - 1, b = n - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] < B[b]) {
                A[a+b+1] = B[b]; //index of A is not a+b, but a+b+1
                b--;
            } else {
                A[a+b+1] = A[a];
                a--;
            }
        }
        
        while (b >= 0) {
            A[b] = B[b];
            b--;
        }
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
