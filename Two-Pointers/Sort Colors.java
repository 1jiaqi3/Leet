//Given an array with n objects colored red, white or blue, 
//sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
public class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length-1;
        int cur = 0;
        while (cur <= blue) {
            if (nums[cur] == 0) {
                swap(nums, red, cur);
                red++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, blue, cur);
                blue--;
            } else {
                cur++;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
