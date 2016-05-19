/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate(1, n);
    }
    public LinkedList<TreeNode> generate(int left, int right) {
        LinkedList<TreeNode> ret = new LinkedList<>();
        if (left > right) {
            ret.add(null);
            return ret;
        }
        for (int i = left; i <= right; i++) {
            LinkedList<TreeNode> l = generate(left, i - 1);
            LinkedList<TreeNode> r = generate(i + 1, right);
            for (int j = 0; j < l.size(); j++) {
                for (int k = 0; k < r.size(); k++) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l.get(j);
                    cur.right = r.get(k);
                    ret.add(cur);
                }
            }
        }
        return ret;
    }
}
