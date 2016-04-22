/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] nTable = nextTable(needle);
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = nTable[j - 1];
            } 
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
    public int[] nextTable(String needle) {
        int[] nTable = new int[needle.length()];
        nTable[0] = 0;
        for (int i = 1, j = 0; i < nTable.length; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = nTable[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            nTable[i] = j;
        }
        return nTable;
    }
}
