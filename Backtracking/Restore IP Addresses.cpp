/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/
class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> ret;
        backtracking(ret, 3, s, "");
        return ret;
    }
    void backtracking(vector<string>& ret, int level, string s, string prefix) {
        if (level == 0 && s.size() > 0 && s.size() <= 3) {
            if (s[0] != '0' || s.size() == 1) {
                int last = stoi(s);
                if (last >= 0 && last < 256) {
                    ret.push_back(prefix + s);
                }
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                string cur = s.substr(0, i);
                if (s.size() <= 12 && s.size() >= i && (cur[0] != '0' || cur.size() == 1) && stoi(cur) < 256) {
                    backtracking(ret, level - 1, s.substr(i), prefix + cur + '.');
                }
            }
        }
    }
};
