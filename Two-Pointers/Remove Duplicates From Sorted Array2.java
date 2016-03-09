//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?

//For example,
//Given sorted array nums = [1,1,1,2,2,3],

//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
//It doesn't matter what you leave beyond the new length.
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) { 
            return nums.length;
        }
        int p1 = 2;
        for (int p2 = p1; p2 < nums.length; p2++) {
            if (nums[p2] > nums[p1 - 2]) {
                nums[p1] = nums[p2];
                p1++;
            }
        }
        return p1;
    }
}
