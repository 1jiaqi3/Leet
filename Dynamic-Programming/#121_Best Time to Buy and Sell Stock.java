//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
//design an algorithm to find the maximum profit.
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int[] dp=new int[prices.length];
        int min=prices[0];
        dp[1]=prices[1]-prices[0];
        for(int i=2;i<dp.length;i++){
            min=Math.min(min, prices[i-1]);
            dp[i]=Math.max(dp[i-1],prices[i]-min);
        }
        return Math.max(dp[dp.length-1],0);
    }
}
