package com.Arrays;

public class Q1_ReverseArray {

	public static void reverseArray(int arr[]) {
		int n = arr.length;
		int start = 0, end = n - 1;

		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void reverseArrayRevursive(int arr[], int start, int end) {
		
		if(start >= end)
			return;
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;	
		reverseArrayRevursive(arr, start+1, end-1);

	}



}
