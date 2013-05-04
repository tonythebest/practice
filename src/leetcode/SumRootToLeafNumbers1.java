package leetcode;

/**
 * LeetCode
 * Sum Root to Leaf Numbers 

Sum Root to Leaf NumbersFeb 191455 / 4078
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

 * this is a good DSF example; to solve most DSF questions, you can always
 * create two lists (or arrays, or other data structures). one list store all
 * paths so far. Another list store the current path: add a new node when move
 * forward, remove a node when move backward. whenever a leaf node is reached,
 * add the current path into the path list.
 * 
 * SumRootToLeafNumbers1 is a little verbose
 * 
 * @author zingshow
 * 
 */

public class SumRootToLeafNumbers1 {

	public int sumNumbers(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] sumPath = new int[] { 0, 0 };
		if (root != null) {
			dsf(root, sumPath);
		}
		return sumPath[0];
	}

	public void dsf(TreeNode node, int[] sumPath) {
		if (node.left != null) {
			sumPath[1] = sumPath[1] * 10 + node.val;
			dsf(node.left, sumPath);
			sumPath[1] = (sumPath[1] - node.val) / 10;
		}
		if (node.right != null) {
			sumPath[1] = sumPath[1] * 10 + node.val;
			dsf(node.right, sumPath);
			sumPath[1] = (sumPath[1] - node.val) / 10;
		}
		sumPath[1] = sumPath[1] * 10 + node.val;
		if (node.left == null && node.right == null) {
			sumPath[0] = sumPath[0] + sumPath[1];
		}
		sumPath[1] = (sumPath[1] - node.val) / 10;
	}

	public static class TreeNode { // the class inside a class can be used both
									// internally and externally
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

		SumRootToLeafNumbers1 x = new SumRootToLeafNumbers1();
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(9);
		t.right = new TreeNode(0);
		t.left.right = new TreeNode(1);
		System.out.println(x.sumNumbers(t));

	}

}
