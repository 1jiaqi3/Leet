/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        if (k > prices.length / 2) {
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i + 1] > prices[i]) {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }
        int[][] dp = new int[k + 1][prices.length];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < k; i++) {
            dp[i][0] = 0;
        }        
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(dp[i - 1][j] - prices[j], localMax);
            }
        }
        return dp[k][prices.length - 1];
    }
}
