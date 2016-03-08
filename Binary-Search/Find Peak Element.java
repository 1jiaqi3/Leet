//A peak element is an element that is greater than its neighbors.

//Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

//You may imagine that num[-1] = num[n] = -∞.

//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
//Note:
//Your solution should be in logarithmic complexity.
public class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid1 = (start + end) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] > nums[mid2]) {
                end = mid1;
            } else if (nums[mid1] < nums[mid2]) {
                start = mid1 + 1;
            }
        }
        return start;
    }
}
