/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ret = 0;
        for (int n : nums) {
            if (!set.contains(n)) {
                set.add(n);
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                count++;
                int head = nums[i];
                while (set.contains(++head)) {
                    count++;
                }
                ret = Math.max(ret, count);
                count = 0;
            }
        }
        return ret;
    }
}
