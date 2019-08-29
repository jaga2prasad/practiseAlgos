package com.jaga.dp;

public class MaxStock {
	//only one trasaction per day
	public static int maxProfit(int[] prices){
		  int currMax = 0;
		  int totalMax = 0;
		  for(int i = 1; i < prices.length; i++){
		      currMax = Math.max(0, currMax+prices[i]-prices[i-1]);
		      totalMax = Math.max(totalMax, currMax);
		  }
		  return totalMax;
		}
	
	//multiple trasncation on day
	public static  int maxProfitDay(int[] prices) {
	    int max = 0;
	    for(int i = 1; i < prices.length; i++){
	        int tmp = prices[i]-prices[i-1];
	        if(tmp > 0){
	            max += tmp; 
	        }
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		int[] stock = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(stock));
		System.out.println(maxProfitDay(stock));
	}
}
