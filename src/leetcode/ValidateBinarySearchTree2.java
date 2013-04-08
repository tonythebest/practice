/**
 * This is wrong, as passing by object is not correct
 */
package leetcode;

public class ValidateBinarySearchTree2 {

    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return true;
        //if (root.left == null && root.right == null) return true;
        
        Integer preVal = Integer.MIN_VALUE;
        return inOrder (root, preVal);
        
    }
    
    public boolean inOrder(TreeNode root, Integer preVal) {
        
        if (root == null) return true;
        
        if (!inOrder(root.left, preVal)) return false;
        
        if (preVal >= root.val) {
            return false;
        } else {
            preVal = root.val;
        }
        
        if (!inOrder(root.right, preVal)) return false;
        
        return true;
    }

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 10;
		for (k = k; k>=0; k--) {
			System.out.println(k);
		}
		
	}

}
