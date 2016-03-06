/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
**/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        traversal(ret, 0, root);
        return ret;
    }
    public void traversal(List<List<Integer>> ret, int level, TreeNode root){
        if (root == null) {
            return;
        } else {
            if (ret.size() <= level) {
                List<Integer> levelList = new ArrayList<>();
                ret.add(levelList);
            }
            ret.get(level).add(root.val);
            traversal(ret, level + 1, root.left);
            traversal(ret, level + 1, root.right);
        }
    }
}
