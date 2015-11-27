//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

//For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//the contiguous subarray [4,−1,2,1] has the largest sum = 6.

//Method 1
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxSum=Math.max(maxSum,sum);
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }
}

//Method 2 (same logic, though)
public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
}
