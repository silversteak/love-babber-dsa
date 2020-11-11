package com.Arrays;

public class Q17_Buy_And_Sell_Stocks {

	/*
	 * peak valley approach 
	 * 1st find buy in the valley and then sell
	 */
	
	public static int maxProfitII(int prices[]) {
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		int maxprofit = 0;
		while (i < prices.length - 1) {
			while (i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			valley = prices[i];
			while (i < prices.length - 1 && prices[i] <= prices[i + 1])
				i++;
			peak = prices[i];
			maxprofit += peak - valley;
		}
		return maxprofit;
	}
	
	/**
	 * This approach is quite similar to normal peak valley approach
	 * 
	 * 10 40 30 60 100
	 * 
	 * ans -- 
	 * 
	 * @param prices
	 * @return
	 */
	
	public static int maxProfitIIB(int prices[]) {
		int i = 0;
		int valley = prices[0];
		int peak = prices[0];
		int maxprofit = 0;
		while (i < prices.length - 1) {
			while (i < prices.length - 1 && prices[i] >= prices[i + 1])
				i++;
			valley = prices[i];
			while (i < prices.length - 1 && prices[i] <= prices[i + 1])
				i++;
			peak = prices[i];
			maxprofit += peak - valley;
		}
		return maxprofit;
	}
	
	
	
	/*
	 * stock span problem 3 leetcode
	 * 2 stocks -- 1st buy and 1st sell and 2nd buy and 2nd sell
	 * 
	 * */
	
	
	public static int maxProfitIII(int prices[]) {
		
		if(prices.length <= 0)
			return 0;
		
		int fb = Integer.MIN_VALUE, sb = Integer.MIN_VALUE;
		int fs = 0, ss = 0;
		
		for(int i = 0; i < prices.length; i++) {
			fb = Math.max(fb, -prices[i]);
			fs = Math.max(fs, fb + prices[i]);
			sb = Math.max(sb, fs - prices[i]);
			ss = Math.max(ss, sb + prices[i]);
		}
		
		return ss;
	}
	
	

	
	// DP[len][2]
	/*
	 * case 1 : we have a stock on day i , dp[i][1] max of the two
	 * 	
	 * i bought it today
	 * 	dp[i-2][0] - prices[i]
	 * 
	 * i am carry forwarding	
	 * 	dp[i-1][1]
	 * 
	 * case 2 : no stock on day i , dp[i][0] max of the two
	 * 
	 * i sold it today
	 * 	dp[i-1][1] + price[i]
	 * 
	 * i am carry forwarding, doing nothing
	 * 	dp[i-i][0]
	 * 
	 * 
	 * */
	
	public int maxProfit(int[] prices) {
		int len = prices.length;
		
		if(len <= 1)
			return 0;
		
		if(len == 2 && prices[1] > prices[0]) {
			return prices[1] - prices[0];
		}else if(len == 2 && prices[0] < prices[1]) {
			return 0;
		}
		
		int dp[][] = new int[len][2];
		
		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
		dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
		
		for(int i = 2; i < len; i++) {
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[1]);
		}
		
		return dp[len-1][0];
	}
	

	
}
