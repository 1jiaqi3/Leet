/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int level = height(root);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            List<Integer> levelList = new ArrayList<>();
            result.add(levelList);
        }
        traversal(result, level-1, root);
        return result;
    }
    public void traversal(List<List<Integer>> list, int level, TreeNode root){
        if (root != null) {
            list.get(level).add(root.val);
            traversal(list, level - 1, root.left);
            traversal(list, level - 1, root.right);
        }
    }
    public int height(TreeNode root){
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(height(root.left),height(root.right));
        }
    }
}
