/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        traverse(ret, root, 0);
        return ret;
    }
    public void traverse(List<List<Integer>> ret, TreeNode root, int level) {
        if (root != null) {
            if (ret.size() <= level) {
                List<Integer> levelList = new LinkedList<>();
                ret.add(levelList);
            }
            if (level % 2 == 0) {
                ret.get(level).add(root.val);
            } else {
                ret.get(level).add(0, root.val);   
            }
            traverse(ret, root.left, level + 1);
            traverse(ret, root.right, level + 1);            
        }
    }
}
