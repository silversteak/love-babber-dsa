package com.BinaryTree;

public class Q3_Height_of_Tree {
	
	public static class Node{
		int val;
		Node left, right;
		public Node(int val, Node left, Node right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
	}
	
	public static int getHeight(Node head) {
		
		if(head == null)
			return 0;
		
		int leftHeight = 1 + getHeight(head.left);
		int rightHeight = 1 + getHeight(head.right);
		
		return Math.max(leftHeight, rightHeight);
	}
	

}
