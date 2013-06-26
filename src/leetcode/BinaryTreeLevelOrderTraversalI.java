package leetcode;

/**
 * LeetCode
 * Binary Tree Level Order Traversal
 * 
Given a binary tree, return the level order traversal of its nodes' values. 
(ie, from left to right, level by level).
For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 * solution by zingshow on June 25, 2013
 * The key of the level order traversal is Queue: every new node and its left and 
 * right node are enqueued. Dequeued nodes are printed in level order traversal.
 * The difference in this problem is each level is one ArrayList, so the depth of each
 * node must be recorded and also stored in queue. When dequeuing a node 
 * and its depth is different from the 
 * previous dequeued node, a new ArrayList must be created.   
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeLevelOrderTraversalI {
	
	public static class TreeNode { // the class inside a class can be used both
		// internally and externally
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        if (root == null) return list;

        queue.add(root);
        ArrayList<Integer> index = new ArrayList<Integer>();
        index.add(0);
        int prevN = 0;
        ArrayList<Integer> ints = new ArrayList<Integer>();
        while (queue != null && queue.size() > 0) {
            int n = index.get(0);
            index.remove(0);
            TreeNode t = queue.get(0);
            queue.remove(0);
            
            if (prevN != n) {
                list.add(ints);
                ints = new ArrayList<Integer>();
                ints.add(t.val);
            } else {
                ints.add(t.val);
            }
            
            prevN = n;
            
            if (t.left != null) {
                queue.add(t.left);
                index.add(n+1);
            }
            if (t.right != null) {
                queue.add(t.right);
                index.add(n+1);
            }
            
        }
        
        list.add(ints);
        
        return list;   
    }

	/**
	 * method to convert an ArrayList<ArrayList<String>> into a two dimensional
	 * array, the second dim size is dynamic
	 * 
	 * @param a
	 * @return
	 */
	public static Integer[][] convertArrayListOfArrayListToIntegerArray(
			ArrayList<ArrayList<Integer>> a) {
		Integer[][] s = new Integer[a.size()][];
		for (int i = 0; i < a.size(); i++) {
			s[i] = (Integer[]) a.get(i).toArray(new Integer[a.get(i).size()]);
		}

		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		System.out.println(a.get(0));
		a.remove(0);
		System.out.println(a.get(0));
		a.remove(0);
		System.out.println(a.get(0));
		a.remove(0);

		BinaryTreeLevelOrderTraversalI x = new BinaryTreeLevelOrderTraversalI();
		
		TreeNode t = new TreeNode(4);
		t.left = new TreeNode(9);
		t.right = new TreeNode(0);
		t.left.right = new TreeNode(1);
		
		ArrayList<ArrayList<Integer>> y = x.levelOrder(t);
		System.out.println(Arrays.deepToString(convertArrayListOfArrayListToIntegerArray(y)));
		
	}

}
