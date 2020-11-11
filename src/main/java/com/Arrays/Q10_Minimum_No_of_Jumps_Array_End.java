package com.Arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q10_Minimum_No_of_Jumps_Array_End {

	public int helper(int[] nums, int []dp, int start){

		int n = nums.length;
		
		// When it reaches the last index return zero
		if(start == n - 1)
			return 0;

		// IF it exceeds the last index 
		if(start >= n || nums[start] == 0)
			return n;

		// Memo power
		if(dp[start] != n)
			return dp[start];

		int steps = n;

		// Loop each posiblities
		for(int i = 1; i <= nums[start]; i++){
			int temp = 1 + helper(nums, dp, start+i);
			steps = Math.min(temp, steps);
		}
		dp[start] = steps;
		return dp[start];

	}

	public int jump(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];
		if(n == 0)
			return 0;
		if(n == 1 && nums[0] == 0)
			return 0;
		Arrays.fill(dp, n);
		int min = helper(nums,dp, 0);

		return min;
	}
	
	public int jumpBFS(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int depth = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                int index = q.remove();
                if(index==nums.length-1) return depth;
                for(int j=1; j<=nums[index]; j++)
                {
                    int neighbor_index = index + j;
                    //if(neighbor_index==nums.length-1) return depth+1;
                    if(neighbor_index>nums.length-1) break;
                    if(visited[neighbor_index]) continue;
                    q.add(neighbor_index);
                    visited[neighbor_index]=true;
                }
            }
            depth++;
        }
        return -1;   
    }
	
}
