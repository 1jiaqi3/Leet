/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    public void flatten(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                TreeNode tmp = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode last = root.right;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = tmp;
            }
            flatten(root.right);
        }
    }
}
