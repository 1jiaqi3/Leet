//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
//For "bbbbb" the longest substring is "b", with the length of 1.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
		int p1 = 0, maxLen = 0;
		for (int p2 = 0; p2 < s.length(); p2++) {
			while (exist[s.charAt(p2)]) {
			    exist[s.charAt(p1)] = false;
				p1++;
			}
			exist[s.charAt(p2)] = true;
			maxLen = Math.max(maxLen, p2 - p1 + 1);
		}
		return maxLen;
    }
}
