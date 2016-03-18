/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        int star = -1;
        int sBack = -1;
        int sPointer = 0;
        int pPointer = 0;
        while (sPointer < s.length()) {
            if (pPointer < p.length() && (s.charAt(sPointer) == p.charAt(pPointer) || p.charAt(pPointer) == '?')) {
                sPointer++;
                pPointer++;
            } else if (pPointer < p.length() && p.charAt(pPointer) == '*') {
                star = pPointer;
                sBack = sPointer;
                pPointer++;
            } else if (star != -1) {
                pPointer = star + 1;
                sBack++;
                sPointer = sBack;
            } else {
                return false;
            }
        }
        while (pPointer < p.length() && p.charAt(pPointer) == '*') {
            pPointer++;
        }
        return pPointer == p.length();
    }
}
