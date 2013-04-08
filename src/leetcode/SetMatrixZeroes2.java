/**
 * A better solution using O(2) space:
 * Add two additional variables storing the zero situations 
 * for the first row and the first column.
 * Store remaining rows' and columns' zero situation 
 * in the first row and the first column.
 * After changing values for rows 1 to m-1 and columns 1 to n-1,
 * change values for row 1 and column 1 by the two variables
 */
package leetcode;

public class SetMatrixZeroes2 {

    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix == null) return;
        int m = matrix.length, n = matrix[0].length;
        int firstRow = 1, firstCol = 1;
        
        // check if the first column should be zero or not
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstCol = 0;
                break;
            }
        }
        
        // check if the first row should be zero or not
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRow = 0;
                break;
            }
        }
        
        // check the remaining rows and cols
        // if any cell is zero, make the same col in the first row zero
        // and make the same row in the first col zero
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // change the row cells to zeros by checking the first col of each row 
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // change the col cells to zeros by checking the first row of each col
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // change the first row
        if (firstRow == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        // change the first col
        if (firstCol == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
