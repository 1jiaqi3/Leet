/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
class Solution {
public:
    vector<string> wordBreak(string s, unordered_set<string>& wordDict) {
        vector<string> ret;
        vector<bool> dp(s.size() + 1, false);
        dp[0] = true;
        for (int i = 1; i < s.size() + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.find(s.substr(j, i - j)) != wordDict.end()) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[s.size()]) {
            return ret;
        }
        backtracking(wordDict, ret, s, "");
        return ret;
    }
    void backtracking(unordered_set<string>& wordDict, vector<string>& ret, string s, string soFar) {
        if (s == "") {
            ret.push_back(soFar.substr(0, soFar.size() - 1));
        } else {
            for (int i = 1; i <= s.size(); i++) {
                if (wordDict.find(s.substr(0, i)) != wordDict.end()) {
                    backtracking(wordDict, ret, s.substr(i), soFar + s.substr(0, i) + " ");
                }
            }
        }
    }
};
