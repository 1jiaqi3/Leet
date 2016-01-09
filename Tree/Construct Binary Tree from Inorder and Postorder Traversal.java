//Given inorder and postorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        int start1=0;
        int start2=0;
        int end2=postorder.length-1;
        int end1=inorder.length-1;
        return build(inorder,postorder,map,start1,end1,start2,end2);
    }
    public TreeNode build(int[] inorder,int[] postorder,HashMap<Integer,Integer> map,int start1,int end1,int start2,int end2){
        if(end1<start1||end2<start2) return null;
        TreeNode root=new TreeNode(postorder[end2]);
        int mid=map.get(postorder[end2]);
        int num=mid-start1;
        root.left=build(inorder,postorder,map,start1,mid-1,start2,start2+num-1);
        root.right=build(inorder,postorder,map,mid+1,end1,start2+num,end2-1);
        return root;
    }
}
