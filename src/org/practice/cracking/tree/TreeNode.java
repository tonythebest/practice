package org.practice.cracking.tree;

import org.practice.cracking.queue.*;

public class TreeNode {

	private TreeNode parent;
	private TreeNode left;
	private TreeNode right;
	private Object data;
	
	public TreeNode (TreeNode p, TreeNode l, TreeNode r, Object d) {
		parent = p;
		left = l;
		right = r;
		data = d;
	}
	
	
	public TreeNode() {
		this (null,null,null,null);
	}
	
	public void setLeft(TreeNode l) {
		left = l;
	}
	
	public void setRight(TreeNode r) {
		right = r;
	}
	
	public void setParent (TreeNode p) {
		parent = p;
	}
	
	public TreeNode getLeft () {
		return left;
	}

	public TreeNode getRight () {
		return right;
	}
	
	public TreeNode getParent () {
		return parent;
	}
	
	public Object getData () {
		return data;
	}
	
	public void preorder() {
		System.out.println(this.getData());
		if (this.getLeft()!=null) this.getLeft().preorder();
		if (this.getRight()!=null) this.getRight().preorder();	
	}
	
	public void inorder() {
		if (this.getLeft()!=null) this.getLeft().inorder();
		System.out.println(this.getData());
		if (this.getRight()!=null) this.getRight().inorder();	
	}
	
	public void postorder() {
		if (this.getLeft()!=null) this.getLeft().postorder();
		if (this.getRight()!=null) this.getRight().postorder();	
		System.out.println(this.getData());
	}
	
	public void levelPrint() { //breadth first BFS
		QueueList queue = new QueueList ();
		queue.enqueue(this);
		while (queue.getSize()!=0) {
			TreeNode node = (TreeNode) queue.dequeue();
			if (node.left!=null) queue.enqueue(node.left);
			if (node.right!=null) queue.enqueue(node.right);
			System.out.println(node.getData());
		}
		
	}
	
}
