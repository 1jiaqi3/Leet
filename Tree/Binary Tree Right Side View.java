/*
Given a binary tree, imagine yourself standing on the right side of it, 
return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        rightSide(root, ret, 0);
        return ret;
    }
    public void rightSide(TreeNode root, List<Integer> ret, int level) {
        if (root != null) {
            if (ret.size() <= level) {
                ret.add(root.val);
            }
            rightSide(root.right, ret, level + 1);
            rightSide(root.left, ret, level + 1);
        }
    }
}
