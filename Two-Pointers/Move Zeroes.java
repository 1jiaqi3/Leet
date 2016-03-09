//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

//Note:
//You must do this in-place without making a copy of the array.
//Minimize the total number of operations.

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length > 1) {
           int p1 = 0;
           int p2 = 0;
           while (p2 < nums.length) {
               if (nums[p2] != 0) {
                   swap(nums, p1, p2);
                   p1++;
               }
               p2++;
           }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
