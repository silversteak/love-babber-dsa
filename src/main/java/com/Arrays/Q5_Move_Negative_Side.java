package com.Arrays;

public class Q5_Move_Negative_Side {


	public static void rearrange(int arr[], int n) {
		
		int low = 0, high = n-1;
		
		while(low <= high) {
			if(arr[low] < 0 && arr[high] > 0) {
				low++; high--;
			}else if(arr[low] > 0 && arr[high] < 0) {
				swap(arr, low, high);
				low++;
				high--;
			}else if(arr[low] < 0 && arr[high] < 0) {
				low++;
			}else if(arr[low] > 0 && arr[high] > 0) {
				high--;
			}
		}
		
	}

	private static void swap(int[] arr, int low, int mid) {
		int temp = arr[low];
		arr[low] = arr[mid];
		arr[mid] = temp;
	}
}