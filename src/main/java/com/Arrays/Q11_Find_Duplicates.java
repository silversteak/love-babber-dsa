package com.Arrays;

public class Q11_Find_Duplicates {

	public int findDuplicate(int[] nums) {

		if(nums == null)
			return -1;

		for(int i = 0 ; i < nums.length; i++) {
			if(nums[Math.abs(nums[i])] > 0)
				nums[Math.abs(nums[i])] = -1 * nums[Math.abs(nums[i])];
			else
				return Math.abs(nums[i]);
		}

		return 0;
	}	

	public int findDuplicateCycleDetection(int[] nums) {
		// Find the intersection point of the two runners.
		int tortoise = nums[0];
		int hare = nums[0];
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (tortoise != hare);

		// Find the "entrance" to the cycle.
		tortoise = nums[0];
		while (tortoise != hare) {
			tortoise = nums[tortoise];
			hare = nums[hare];
		}

		return hare;
	}


}
