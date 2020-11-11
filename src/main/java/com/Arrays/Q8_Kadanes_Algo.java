package com.Arrays;

public class Q8_Kadanes_Algo {

	public static int findMaxSubArray(int arr[], int n) {
		if(arr == null)
			return -1;

		int currMax = arr[0], max = arr[0];
		int start = 0, end = 0;
		for(int i = 1; i < n; i++){
			if(currMax + arr[i] > arr[i]){
				currMax = currMax + arr[i];
				end = i;
			}else{
				currMax = arr[i];
				start = i;
			}
			if(max < currMax){
				max = currMax;
			}

		}
		System.out.println(start + "     " + end);
		return max;
	}

	public int maxSubarraySumCircular(int[] A) {

		if(A == null)
			return -1;

		int n = A.length;

		int maxSum = A[0];
		int currSum = maxSum;
		int currMin = A[0];
		int minSum = A[0];
		int totalSum = A[0];
		for(int i = 1; i < n; i++){
			currSum = Math.max(A[i], A[i] + currSum);
			maxSum = Math.max(currSum, maxSum);
			currMin = Math.min(A[i], A[i] + currMin);
			minSum = Math.min(minSum, currMin);
			totalSum += A[i];
		}
		return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum ;
	}


}
