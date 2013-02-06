package org.practice.cracking.tree;

public class TreeTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N1 = 15;
		TreeNode[] treeNodes = new TreeNode[N1];
		treeNodes[0] = new TreeNode(null,null,null,0);
		Tree tree1 = new Tree(treeNodes[0]);
		
		for (int i = 1; i<N1; i++) {
			System.out.println("*** current = "+i);
			System.out.println("*** parent  = "+(i-1)/2);
			int parentIndex = (i-1)/2;
			
			treeNodes[i] = new TreeNode(null,null,null,i);
			treeNodes[i].setParent(treeNodes[parentIndex]);
			if (i%2==1) {
				System.out.println("Odd");
				treeNodes[parentIndex].setLeft(treeNodes[i]);
			}
			else {
				System.out.println("Even");
				treeNodes[parentIndex].setRight(treeNodes[i]);
			}
			tree1.increaseSize();
		}
		
		System.out.println(tree1.getSize());
		System.out.println(tree1.getRoot());
		System.out.println(tree1.getRoot().getData());
		System.out.println(tree1.getRoot().getLeft());
		System.out.println(tree1.getRoot().getLeft().getData());
		System.out.println(tree1.getRoot().getLeft().getParent());
		System.out.println(tree1.getRoot().getLeft().getParent().getData());
		System.out.println(tree1.getRoot().getLeft().getParent().getLeft());
		System.out.println(tree1.getRoot().getLeft().getParent().getRight());

		System.out.println("*** preorder");
		treeNodes[0].preorder();
		System.out.println("*** inorder");
		treeNodes[0].inorder();
		System.out.println("*** postorder");
		treeNodes[0].postorder();
		System.out.println("*** inorder from node 1");
		treeNodes[1].inorder();
		System.out.println("*** level order (breadth first BFS)");
		treeNodes[0].levelPrint();
		
	}
	

}
