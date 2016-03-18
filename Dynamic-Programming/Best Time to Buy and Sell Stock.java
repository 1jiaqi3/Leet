//Say you have an array for which the ith element is the price of a given stock on day i.

//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
//design an algorithm to find the maximum profit.
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int max = prices[1] - prices[0];
        for(int i = 2; i < prices.length; i++) {
            min = Math.min(min, prices[i - 1]);
            max = Math.max(max, prices[i] - min);
        }
        return Math.max(max, 0);
    }
}
