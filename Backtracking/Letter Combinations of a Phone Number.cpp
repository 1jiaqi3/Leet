/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
class Solution {
public:
    vector<string> letterCombinations(string digits) {
        vector<string> map {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<string> ret;
        if (digits.size() == 0) {
            return ret;
        }
        backtracking(map, ret, 0, digits, "");
        return ret;
    }
    void backtracking(vector<string> map, vector<string> &ret, int level, string digits, string soFar) {
        if (level == digits.size()) {
            ret.push_back(soFar);
        } else {
            string cur = map[digits[level] - '0'];
            for (int i = 0; i < cur.size(); i++) {
                backtracking(map, ret, level + 1, digits, soFar + cur[i]);
            }
        }
    }
};
