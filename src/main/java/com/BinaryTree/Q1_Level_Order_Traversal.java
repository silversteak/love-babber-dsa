package com.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Q1_Level_Order_Traversal {
	
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
	
	public static void print(Node head) {
		if(head == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		while(!queue.isEmpty()) {
			Node temp = queue.peek();
			System.out.println(temp.val);
			if(temp.left != null)
				queue.add(temp.left);
			if(temp.right != null)
				queue.add(temp.right);
		}
		
	}
	
	/**
	 * There can be multiple variations of the question,
	 * 1. print line by line -- use length of the queue
	 */
	
}
