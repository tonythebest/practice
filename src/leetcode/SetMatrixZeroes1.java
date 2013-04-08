/**
 * A simple improvement uses O(m + n) space, but still not the best solution.
 */
package leetcode;

public class SetMatrixZeroes1 {

	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null)
			return;
		int m = matrix.length, n = matrix[0].length;
		int[] rows = new int[m], cols = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (rows[i] == 1) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 0; j < n; j++) {
			if (cols[j] == 1) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		// do not change the value in the first row and the first column, to
		// keep information
		// change the first row/column later
		// if (matrix[0][0] == 0) {
		// for (int i = 0; i < m; i++) {
		// matrix[i][0] = 0;
		// }
		// for (int j = 0; j < n; j++) {
		// matrix[0][j] = 0;
		// }
		// }

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
