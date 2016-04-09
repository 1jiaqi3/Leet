/*
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/

class Solution {
public:
    string removeDuplicateLetters(string s) {
        string ret = "0";
        int table[26] = {};
        bool in[26] = {};
        for (int i = 0; i < s.size(); i++) {
            table[s[i] - 'a']++;
        }
        for (int i = 0; i < s.size(); i++) {
            table[s[i] - 'a']--;
            if (in[s[i] - 'a']) {
                continue;
            }
            while (table[ret.back() - 'a'] > 0 && s[i] < ret.back()) {
                in[ret.back() - 'a'] = false;
                ret.pop_back();
            }
            ret += s[i];
            in[s[i] - 'a'] = true;
        }
        return ret.substr(1);
    }
};
