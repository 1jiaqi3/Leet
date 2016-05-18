/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                if (!set.contains(nums1[p1])) {
                    set.add(nums1[p1]);
                }
                p1++;
                p2++;
            }
        }
        int[] ret = new int[set.size()];
        int i = 0;
        for (int val : set) ret[i++] = val;
        return ret;
    }
}
