/**
 * this is always correct by using array for passing by reference
 */
package leetcode;

public class ValidateBinarySearchTree1 {

	public boolean isValidBST(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return true;
		// if (root.left == null && root.right == null) return true;

		int[] preVal = new int[1];
		preVal[0] = Integer.MIN_VALUE;
		return inOrder(root, preVal);

	}

	public boolean inOrder(TreeNode root, int[] preVal) {

		if (root == null)
			return true;

		if (!inOrder(root.left, preVal))
			return false;

		if (preVal[0] >= root.val) {
			return false;
		} else {
			preVal[0] = root.val;
		}

		if (!inOrder(root.right, preVal))
			return false;

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

	}

}
