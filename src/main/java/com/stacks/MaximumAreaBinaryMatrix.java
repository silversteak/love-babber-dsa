package com.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class MaximumAreaBinaryMatrix {

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

	public static int calArea(int arr[]) {

		int n = arr.length;

		List<Integer> left = getPreviousMinimum(arr, n);
		List<Integer> right = getNextMinimum(arr, n);

		int max = Integer.MIN_VALUE;

		for(int i = 0; i < n; i++) {
			max = Math.max(max, (right.get(i) - left.get(i) - 1) * arr[i]);
		}

		return max;
	}

	public static int binaryArea(int [][] A) {

		int max = Integer.MIN_VALUE;

		max = Math.max(max, calArea(A[0]));

		for(int i = 1; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				if(A[i][j] != 0) {
					A[i][j] += A[i-1][j];
				}
			}
			max = Math.max(max,calArea(A[i]));
		}

		return max;
	}


}
