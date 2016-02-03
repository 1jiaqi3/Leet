/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
*/
public class Solution {
    public int calculate(String s) {
        int sign = 1;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(sign * stack.peek());
                sign = 1;
            } else if (s.charAt(i) == ')') {
                stack.pop();
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (int)(s.charAt(i) - 48);
                    i++;
                }
                i--;
                result += stack.peek() * sign * num;
            }
        }
        return result;
    }
}
