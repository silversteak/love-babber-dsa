package com.Arrays;

public class Q2_Min_Max_in_an_Array {
	
	static class Pair{
		int max;
		int min;
	}
	
	// Linear search algorithm -- with 1 + 2(n-2) comparisions 
	public static Pair getMinMax(int arr[]) {
		int n = arr.length;
		Pair pair = new Pair();
		
		if(n == 1) {
			pair.max = arr[0];
			pair.min = arr[0];
		}
		
		if(arr[0] > arr[1]) {
			pair.max = arr[0];
			pair.min = arr[1];
		}else {
			pair.max = arr[1];
			pair.min = arr[0];
		}
		
		for(int i = 2; i < n; i++) {
			if(pair.max < arr[i])
				pair.max = arr[i];
			else if(pair.min > arr[i])
				pair.min = arr[i];
		}
		
		return pair;
	}
	
	// Use divide and Conquer method instead
	public static Pair getMinMax(int arr[], int low, int high) {

		Pair res = new Pair();
		Pair left = new Pair();
		Pair right = new Pair();
		
		if(high == low) {
			res.max = arr[low];
			res.min = arr[low];
			return res;
		}
		
		if(high == low + 1) {
			if(arr[low] < arr[high]) {
				res.max = arr[high];
				res.min = arr[low];
			}else {
				res.max = arr[low];
				res.min = arr[high];
			}
			return res;
		}
		
		int mid = low + (high-low)/2;
		
		left = getMinMax(arr, low, mid);
		right = getMinMax(arr, mid+1, high);
		
		if(right.max > left.max) {
			res.max = right.max;
		}else {
			res.max = left.max;
		}
		
		if(left.min < right.min) {
			res.min = left.min;
		}else {
			res.min = right.min;
		}

		return res;
	}
	

}
