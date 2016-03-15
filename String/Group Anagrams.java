/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Arrays.sort(strs);
        int index = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String standard = sortStr(strs[i]);
            if (!map.containsKey(standard)) {
                map.put(standard, index++);
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                ret.add(list);
            } else {
                ret.get(map.get(standard)).add(strs[i]);
            }
        }
        return ret;
    }
    public String sortStr(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
