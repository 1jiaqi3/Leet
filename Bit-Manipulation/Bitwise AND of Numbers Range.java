/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.
*/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int counter = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            counter++;
        }
        for (int i = 0; i < counter; i++) {
            m <<= 1;
        }
        return m;
    }
}
