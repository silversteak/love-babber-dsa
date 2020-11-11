package com.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author Tauseef Rahaman
 *
 * Reverse the logic 
 *
 */
public class Q2_Reverse_Level_Order {

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
		Stack<Node> stk = new Stack<>();
		Queue<Node> q = new LinkedList<>();
		q.add(head);
		q.add(null);

		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp == null) {
				stk.push(null);
				q.add(null);
				continue;
			}else {
				stk.push(temp);
			}

			//stk.push(temp);

			if(temp.right != null)
				q.add(temp.right);

			if(temp.left != null)
				q.add(temp.left);

		}

		while(!stk.isEmpty()) {
			Node temp = stk.pop(); 
			if( temp == null)
				System.out.println();
			else
				System.out.print(temp.val + " ");
		}

	}

}
