//Write a function to find the longest common prefix string amongst an array of strings.
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int min = 0;
        for (int i = 0; i < strs.length; i++){
            if (strs[i].equals("")) return "";
            if (strs[i].length() < strs[min].length()){
                min = i;
            }
        }
        String minStr = strs[min];
        System.out.println(minStr);
        for (int i = 0; i < minStr.length(); i++){
            for (int j = 0; j < strs.length; j++){
                if (minStr.charAt(i) != strs[j].charAt(i)){
                    return minStr.substring(0, i);
                }
            }
        }
        return minStr;
    }
}
