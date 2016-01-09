/**
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
**/
public class Solution {
    public int trailingZeroes(int n) {
        long factor=5;
        int result=0;
        while(factor<=n){
            result+=n/factor;
            factor*=5;
        }
        return result;
    }
}
