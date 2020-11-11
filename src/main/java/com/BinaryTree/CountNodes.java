package com.BinaryTree;

public class CountNodes {

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

	public static int countNodes(Node root) {
		if(root == null)
			return 0;
		return (1+countNodes(root.left)+countNodes(root.right));
	}

	public static int countLeafs(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return (countLeafs(root.left) + countLeafs(root.right));
	}

	public static int countNonLeaves(Node root) {
		if(root == null || (root.left == null && root.right == null))
			return 0;
		return (1+ countNonLeaves(root.left) + countNonLeaves(root.right));
	}


}
