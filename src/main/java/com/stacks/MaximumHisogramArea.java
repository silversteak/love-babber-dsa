package com.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaximumHisogramArea {

	public static class Pair{
		int val;
		int index;
		public Pair(int val, int index) {
			super();
			this.val = val;
			this.index = index;
		}
	}
	
	public static List<Integer> getPreviousMinimum(int arr[], int n){
		Stack<Pair> stack = new Stack<>();
		List<Integer> left = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			if(stack.isEmpty()) {
				left.add(-1);
			}
			else if(!stack.isEmpty() && stack.peek().val < arr[i]) {
				left.add(stack.peek().index);
			}
			else if(!stack.isEmpty() && stack.peek().val >= arr[i]) {
				
				while(!stack.isEmpty() && stack.peek().val >= arr[i]) {
					stack.pop();
				}
			
				if(!stack.isEmpty()) {
					left.add(stack.peek().index);
				}else {
					left.add(-1);
				}
			}
			stack.add(new Pair(arr[i], i));
		}
		return left;
	}
	
	public static List<Integer> getNextMinimum(int arr[], int n){
		Stack<Pair> stack = new Stack<>();
		List<Integer> right = new ArrayList<>();
		for(int i = arr.length - 1; i >= 0; i--) {
			if(stack.isEmpty()) {
				right.add(n);
			}
			else if(!stack.isEmpty() && stack.peek().val < arr[i]) {
				right.add(stack.peek().index);
			}
			else if(!stack.isEmpty() && stack.peek().val >= arr[i]) {
				
				while(!stack.isEmpty() && stack.peek().val >= arr[i]) {
					stack.pop();
				}
			
				if(!stack.isEmpty()) {
					right.add(stack.peek().index);
				}else {
					right.add(n);
				}
			}
			stack.add(new Pair(arr[i], i));
		}
		Collections.reverse(right);
		return right;
	}
	
	public static void calArea(int arr[]) {
		
		int n = arr.length;
		
		List<Integer> left = getPreviousMinimum(arr, n);
		List<Integer> right = getNextMinimum(arr, n);
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			max = Math.max(max, (right.get(i) - left.get(i) - 1) * arr[i]);
		}
		
		System.out.println(max);
	
	}
	
	public static void main(String args[]) {
		int arr[] = { 6, 2, 5, 4, 5, 1, 6 };
		calArea(arr);
	}
	
}
