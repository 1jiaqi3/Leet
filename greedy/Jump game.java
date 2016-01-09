//Given an array of non-negative integers, you are initially positioned at the first index of the array.

//Each element in the array represents your maximum jump length at that position.

//Determine if you are able to reach the last index.

//For example:
//A = [2,3,1,1,4], return true.

//A = [3,2,1,0,4], return false.
public class Solution {
    public boolean canJump(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<dp.length;i++){
            if(dp[i-1]<=0) return false;
            dp[i]=Math.max(dp[i-1]-1,nums[i]);
        }
        return true;
    }
}
