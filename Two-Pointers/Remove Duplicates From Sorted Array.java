//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

//Do not allocate extra space for another array, you must do this in place with constant memory.

//For example,
//Given input array nums = [1,1,2],

//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
//It doesn't matter what you leave beyond the new length.
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int cur = nums[0];
        int p1 = 1;
        int p2 = 1;
        while (p2 < nums.length) {
            if (nums[p2] != cur) {
                cur = nums[p2];
                swap(nums, p1, p2);
                p1++;
            }
            p2++;
        }
        return p1;
    }
    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
