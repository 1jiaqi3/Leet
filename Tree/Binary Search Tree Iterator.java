/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Stack<Integer> myStack=new Stack<>();

    public BSTIterator(TreeNode root) {
        pushInto(root);
    }

    private void pushInto(TreeNode root){
        if (root != null) {
            pushInto(root.right);
            myStack.push(root.val);
            pushInto(root.left);
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !myStack.empty();
    }

    /** @return the next smallest number */
    public int next() {
         return myStack.pop();
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
