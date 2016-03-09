//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.

//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.

//For the purpose of this problem, we define empty string as valid palindrome.


public class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        s = s.toUpperCase();
        while (p1 < p2) {
            while (p1 < p2 && !(Character.isDigit(s.charAt(p1)) || Character.isLetter(s.charAt(p1)))){
                p1++;
            }
            while(p1 < p2 && !(Character.isDigit(s.charAt(p2)) || Character.isLetter(s.charAt(p2)))){
                p2--;
            }
            if (s.charAt(p1) != s.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
