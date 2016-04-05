/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<>();
        List<String> list = new LinkedList<>();
        backtracking(ret, list, s);
        return ret;
    }
    public void backtracking(List<List<String>> ret, List<String> list, String s) {
        if (s.length() == 0) {
            List<String> newList = new LinkedList<>();
            for (String str : list) {
                newList.add(str);
            }
            ret.add(newList);
        } else {
            for (int i = 0; i < s.length(); i++) {
                String cur = s.substring(0, i + 1);
                if (isP(cur)) {
                    list.add(cur);
                    backtracking(ret, list, s.substring(i + 1, s.length()));
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    public boolean isP(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
