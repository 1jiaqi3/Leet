/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/
//Should not use Java on this problem, because Java does not have unsigned number.
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int counter = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                counter++;
            }
            n >>= 1;
        }
        return counter;
    }
};
