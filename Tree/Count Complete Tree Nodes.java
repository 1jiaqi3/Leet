/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.
*/
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = heightL(root.left);
            int right = heightR(root.right);
            if (left == right) {
                return (2 << (left)) - 1;
            } else {
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        }
    }
    public int heightL(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + heightL(root.left);
        }
    }
    public int heightR(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + heightR(root.right);
        }
    }
}
