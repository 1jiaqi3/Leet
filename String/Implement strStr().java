/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++){
            for (int j = i; ; j++){
                if (j - i >= needle.length()) {
                    return i;
                } else if (j >= haystack.length()) {
                    return -1;
                } else if (haystack.charAt(j) != needle.charAt(j - i)) {
                    break;
                }
            }
        }
    }
}
