/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
*/
public class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<Character>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        char[] sArray = s.toCharArray();
        int i = 0;
        int j = sArray.length - 1;
        while (i < j) {
            while (i < j && !set.contains(sArray[i])) {
                i++;
            }
            while (i < j && !set.contains(sArray[j])) {
                j--;
            }
            if (i < j) {
                char temp = sArray[i];
                sArray[i] = sArray[j];
                sArray[j] = temp;
                i++;
                j--;
            }
        }
        return new String(sArray);
    }
}
