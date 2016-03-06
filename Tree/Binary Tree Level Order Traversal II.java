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
        List<List<Integer>> ret = new LinkedList<>();
        traversal(ret, 0, root);
        return ret;
    }
    public void traversal(List<List<Integer>> ret, int level, TreeNode root){
        if (root != null) {
            if (ret.size() <= level) {
                List<Integer> levelList = new LinkedList<>();
                ret.add(0, levelList);
            }
            ret.get(ret.size() - level - 1).add(root.val);
            traversal(ret, level + 1, root.left);
            traversal(ret, level + 1, root.right);
        }
    }
}
