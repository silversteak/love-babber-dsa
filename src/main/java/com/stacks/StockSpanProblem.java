package com.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {

	static class Stock{
		int val;
		int index;
		public Stock(int val, int index) {
			this.val = val;
			this.index = index;
		}	
	}
	
	public static void stockSpan(int arr[]) {

		Stack<Stock> stk = new Stack<>();
		List<Integer> ans = new ArrayList<>();
		int n = arr.length;
		for(int i = 0 ; i < n ; i++) {
			//Check for empty stack
			if(stk.isEmpty()) {
				ans.add(-1);
			}
			//If stack.top() > arr[i]
			if(!stk.isEmpty() && stk.peek().val > arr[i])
				ans.add(stk.peek().index);

			//if stack.top() < arr[i]
			if(!stk.isEmpty() && stk.peek().val <= arr[i]) {
				//Keep poping the element
				while(!stk.isEmpty() && stk.peek().val <= arr[i]) {
					stk.pop();
				}
				// if empty else the last element
				if(stk.isEmpty())
					ans.add(-1);
				else
					ans.add(stk.peek().index);
			}	
			stk.push(new Stock(arr[i], i));	
		}

		for(int i = 0; i < n; i++) {
			ans.add(i, i - ans.get(i));
		}
	}
}
