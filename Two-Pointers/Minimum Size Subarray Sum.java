//Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. 
//If there isn't one, return 0 instead.

//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int min = nums.length + 1;
        while (p2 < nums.length) {
            if (sum < s) {
                sum += nums[p2];
                p2++;
            } else {
                min = Math.min(p2 - p1, min);
                sum -= nums[p1];
                p1++;
            }
        }
        while (sum >= s) {
            min = Math.min(p2 - p1, min);
            sum -= nums[p1];
            p1++;
        }
        return min == nums.length + 1 ? 0 : min;
    }
}
