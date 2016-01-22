/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        if (s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            int len1 = longest(i, i, s);
            int len2 = longest(i, i + 1, s);
            int len = Math.max(len1, len2);
            if (end - start + 1 < len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public int longest(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
