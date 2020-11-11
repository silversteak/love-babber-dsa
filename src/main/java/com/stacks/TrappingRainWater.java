package com.stacks;

public class TrappingRainWater {

	public static int rainWater(int arr[]) {
		
		if(arr == null)
			return -1;
		int ans = Integer.MIN_VALUE;
		int n = arr.length;
		
		int leftMax[] = new int[n];
		int rightMax[] = new int[n];
		leftMax[0] = arr[0];
		for(int i = 1; i < n; i++) {
			leftMax[i] = Math.max(arr[i], leftMax[i-1]);
		}
		
		rightMax[n-1] = arr[n-1];
		
		for(int i = n - 2; i >=0 ; i--) {
			rightMax[i] = Math.max(arr[i], rightMax[i-1]);
		}
		
		for(int i = 0; i < n; i++) {
			ans += Math.min(leftMax[i], rightMax[i]) - arr[i];
		}
		
		return ans;
		
	} 
	
}
