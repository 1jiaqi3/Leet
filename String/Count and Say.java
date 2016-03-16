/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class Solution {
    public String countAndSay(int n) {
        String seq = "1";
        String ret = "";
        int counter = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < seq.length() - 1; j++) {
                if (seq.charAt(j) == seq.charAt(j + 1)) {
                    counter++;
                } else {
                    ret = ret + counter + seq.charAt(j);
                    counter = 1;
                }
            }
            ret = ret + counter + seq.charAt(seq.length() - 1);
            seq = ret;
            ret = "";
            counter = 1;
        }
        return seq;
    }
}
