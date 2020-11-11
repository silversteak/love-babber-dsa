package com.Arrays;

public class Q7_Rotata_By_One {
	
	public static void rotateByOne(int arr[]) {
		if(arr == null)
			return;
		
		int temp = arr[0], n = arr.length;
		
		for(int i = 1; i < n; i++) {
			arr[i-1] = arr[i];
		}
		arr[n-1] = temp;
	}

}
