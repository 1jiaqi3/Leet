//Note: This is an extension of House Robber.

//After robbing those houses on that street, 
//the thief has found himself a new place for his thievery so that he will not get too much attention. 
//This time, all houses at this place are arranged in a circle. 
//That means the first house is the neighbor of the last one. 
//Meanwhile, the security system for these houses remain the same as for those in the previous street.

//Given a list of non-negative integers representing the amount of money of each house, 
//determine the maximum amount of money you can rob tonight without alerting the police.
public class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        int[] dp1=new int[len];
        dp1[0]=0;
        dp1[1]=nums[0];
        int[] dp2=new int[len];
        dp2[0]=0;
        dp2[1]=nums[len-1];
        for(int i=2;i<len;i++){
            dp1[i]=Math.max(dp1[i-1],dp1[i-2]+nums[i-1]);
            dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[len-i]);
        }
        return Math.max(dp1[len-1],dp2[len-1]);
    }
}
