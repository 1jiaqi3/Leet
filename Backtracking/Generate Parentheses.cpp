/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ret;
        backtracking(n, n, ret, "");
        return ret;
    }
    void backtracking(int left, int right, vector<string>& ret, string soFar) {
        if (right == 0) {
            ret.push_back(soFar);
        } else {
            if (left > 0)  {
                backtracking(left - 1, right, ret, soFar + "(");
            }
            if (left < right) {
                backtracking(left, right - 1, ret, soFar + ")");
            }
        }
    }
};
