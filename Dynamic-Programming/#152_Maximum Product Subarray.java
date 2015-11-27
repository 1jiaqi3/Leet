//Find the contiguous subarray within an array (containing at least one number) which has the largest product.

//For example, given the array [2,3,-2,4],
//the contiguous subarray [2,3] has the largest product = 6.
//WRONG ANSWER!!!!!!! Consider the case [0,2] or [-5,2]
public class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int maxProduct=nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp=max;
            max=Math.max(max*nums[i],min*nums[i]);
            min=Math.min(tmp*nums[i],min*nums[i]);
            maxProduct=Math.max(max,maxProduct);
        }
        return maxProduct;
    }
}

//Right Answer!
public class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0];
        int min=nums[0];
        int maxProduct=nums[0];
        for(int i=1;i<nums.length;i++){
            int tmp=max;
            max=Math.max(Math.max(max*nums[i],nums[i]),min*nums[i]);
            min=Math.min(Math.min(tmp*nums[i],nums[i]),min*nums[i]);
            maxProduct=Math.max(max,maxProduct);
        }
        return maxProduct;
    }
}

