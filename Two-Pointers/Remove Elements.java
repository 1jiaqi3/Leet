//Given an array and a value, remove all instances of that value in place and return the new length.

//The order of elements can be changed. It doesn't matter what you leave beyond the new length.
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int p1 = 0; 
        for (int p2 = 0; p2 < nums.length; p2++) {
            if (nums[p2] != val) {
                nums[p1] = nums[p2];
                p1++;
            }
        }
        return p1;
    }
}
