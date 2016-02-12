//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return Convert (nums, 0, nums.length-1);
    }
    public TreeNode Convert (int[] nums, int low, int high){
        if (nums.length == 0) {
            return null;
        }
        int mid = (low + high) / 2;
        if (high < low) {
            return null;
        }
        TreeNode root = new TreeNode (nums[mid]);
        root.left = Convert(nums, low, mid - 1);
        root.right = Convert(nums, mid + 1,high);
        return root;
    }
}
