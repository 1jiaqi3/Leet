
/*Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/
class Solution {
public:
    string shortestPalindrome(string s) {
        if (s.size() == 0) {
            return "";
        }
        string rev = s;
        reverse(rev.begin(), rev.end());
        string ss = s + '.' + rev;
        vector<int> nTable(ss.size());
        nTable[0] = 0;
        for (int i = 1, j = 0; i < nTable.size(); i++) {
            while (j > 0 && ss[i] != ss[j]) {
                j = nTable[j - 1];
            }
            if (ss[i] == ss[j]) {
                j++;
            }
            nTable[i] = j;
        }
        return rev.substr(0, s.size() - nTable[ss.size() - 1]) + s;
    }
};
