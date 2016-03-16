/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int p = i;
            while (p < s.length()) {
                if (i != numRows - 1) {
                    sb.append(s.charAt(p));
                    p = p + 2 * (numRows - i - 1);
                }
                if (p < s.length() && i != 0) {
                    sb.append(s.charAt(p));
                    p = p + 2 * i;
                }
            }
        }
        return sb.toString();
    }
}
