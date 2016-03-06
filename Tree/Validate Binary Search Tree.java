/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    public boolean isBST(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        } else if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        } else {
            return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
        }
    }
}
