package com.LinkedList;

public class InsertionSortOfLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode insertionSortList(ListNode head) {
		ListNode dummyNode = new ListNode(0);
		
		// Create the starting point or the head Node
		ListNode headNode = dummyNode;
		
		ListNode curr = head, prevNode, nextNode;
		
		//Loop untill it reaches null
		while(curr != null){
			//Store the next Node
			nextNode = curr.next;
			
			//Just like insertion sort start from the begining and find the appropiate
			//place for the current Node
			while(headNode.next != null && headNode.next.val < curr.val){
				headNode = headNode.next;
			}

			//Get the next Node of the headNode
			prevNode = headNode.next;
			//Set the headNode of the next to the curr
			headNode.next = curr;
			//set current next to the previous next node of the headNode
			curr.next = prevNode;
			//set the current Node to the nextNode for next iteration
			curr = nextNode;
			//set the headNode to the dummyNode
			headNode = dummyNode;
		}

		return dummyNode.next;
	}

}
