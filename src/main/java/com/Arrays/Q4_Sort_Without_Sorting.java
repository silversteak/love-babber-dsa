package com.Arrays;

public class Q4_Sort_Without_Sorting {

	
	
	/**
	 *
	 * the same thing can be done using counting sort
	 * which is quite straight forward
	 * 
	 * 0-----low = 0
	 * low---mid = 1
	 * mid--high = Unknown
	 * high----n = 2
	 * 
	 * @param arr
	 * @param n
	 */
	public static void dutchNationalFlag(int arr[], int n) {
		int low = 0, mid = 0, high = n - 1;
		while(mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, high);
				high--;
				break;	
			default:
				break;
			}
		}

	}

	private static void swap(int[] arr, int low, int mid) {
		int temp = arr[low];
		arr[low] = arr[mid];
		arr[mid] = temp;
	}
}
