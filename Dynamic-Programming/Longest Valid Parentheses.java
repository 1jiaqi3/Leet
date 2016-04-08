/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
public class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                int last = i - dp[i - 1] - 1;
                if (last >= 0 && s.charAt(last) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (last - 1 >= 0) {
                        dp[i] += dp[last - 1];
                    }
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
