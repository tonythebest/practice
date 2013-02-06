package org.practice.cracking.tree;

public class Tree {
	private TreeNode root;
	private int size;
	
	public Tree(TreeNode r) {
		root = r;
		size = 1;
	}
	
	public Tree() {
		this (null);
		size = 0;
	}
	
	public void increaseSize () {
		size++;
	}
	
	public TreeNode getRoot () {
		return root;
	}
	
	public int getSize () {
		return size;
	}
	
}
