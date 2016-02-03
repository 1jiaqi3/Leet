/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/
public class Solution {
    public int calculate(String s) {
        int intermediate_ret = 0;
        int result = 0;
        s = "+" + s + "+";
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                result += intermediate_ret;
                intermediate_ret = 0;
                int sign = 44 - s.charAt(i);
                i++;
                while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/') {
                    if (Character.isDigit(s.charAt(i))) {
                        intermediate_ret = intermediate_ret * 10 + (s.charAt(i) - '0');
                    }
                    i++;
                }
                intermediate_ret *= sign; 
            } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                char op = s.charAt(i);
                int nextNum = 0;
                i++;
                while (i < s.length() && s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*' && s.charAt(i) != '/') {
                    if (Character.isDigit(s.charAt(i))) {
                        nextNum = nextNum * 10 + (s.charAt(i) - '0');
                    }
                    i++;
                }
                if (op == '*') {
                    intermediate_ret *= nextNum; 
                } else {
                    intermediate_ret /= nextNum;
                }
            }
        }
        return result;
    }
}
