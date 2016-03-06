//Given preorder and inorder traversal of a tree, construct the binary tree.

//Note:
//You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int end1=inorder.length-1;
        int end2=preorder.length-1;
        return build(inorder, preorder, map, 0, end1, 0, end2);
    }
    public TreeNode build(int[] in, int[] pre, HashMap<Integer,Integer> map, int startIn, int endIn, int startPre, int endPre) {
        if (endIn < startIn || endPre < startPre) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        int mid = map.get(root.val);
        int num = mid - startIn;
        root.left = build(in, pre, map, startIn, mid - 1, startPre + 1, startPre + num);
        root.right = build(in, pre, map, mid + 1, endIn, startPre + num + 1, endPre);
        return root;
    }
}
