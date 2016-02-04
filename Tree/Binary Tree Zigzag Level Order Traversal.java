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
import java.util.*;
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int height = getHeight(root);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < height; i++){
            List<Integer> levelList = new ArrayList<>();
            ret.add(levelList);
        }
        traverse(ret, root, 0);
        for (int i = 1; i < height; i += 2) {
            Collections.reverse((ArrayList)(ret.get(i)));
        }
        return ret;
    }
    public void traverse(List<List<Integer>> ret, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        ret.get(level).add(root.val);
        traverse(ret, root.left, level + 1);
        traverse(ret, root.right, level + 1);
    }
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
