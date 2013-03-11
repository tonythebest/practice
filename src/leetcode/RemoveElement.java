package leetcode;

public class RemoveElement {

    public int removeElement(int[] A, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) return 0;
        int current = 0;
        int next = 0;
        while (next < A.length) {
            if (A[next] == x) next++;
            else A[current++] = A[next++]; //put ++ here is good!!!
        }
        return current; //current+1 is wrong!!!
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
