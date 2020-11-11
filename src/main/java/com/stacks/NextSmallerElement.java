package com.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextSmallerElement {

	public static void nextSmallerElement(int arr[]) {

		Stack<Integer> stk = new Stack<>();
		List<Integer> ans = new ArrayList<>();
		int n = arr.length;
		for(int i = n - 1; i >=0 ; i--) {
			//Check for empty stack
			if(stk.isEmpty()) {
				ans.add(-1);
			}
			//If stack.top() < arr[i]
			if(!stk.isEmpty() && stk.peek() < arr[i])
				ans.add(stk.peek());

			//if stack.top() > arr[i]
			if(!stk.isEmpty() && stk.peek() >= arr[i]) {
				//Keep poping the element
				while(!stk.isEmpty() && stk.peek() >= arr[i]) {
					stk.pop();
				}
				// if empty else the last element
				if(stk.isEmpty())
					ans.add(-1);
				else
					ans.add(stk.peek());
			}	
			stk.push(arr[i]);	
		}
		// Since i started from the back (it is next smaller element)
		Collections.reverse(ans);
	}



}
