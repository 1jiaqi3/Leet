/*
Given a binary tree, find the maximum path sum.

For this problem, 
a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxPathSum(TreeNode* root) {
        int maxWithTop = INT_MIN;
        branchSum(root, maxWithTop);
        return maxWithTop;
    }
    int branchSum(TreeNode* root, int &maxWithTop) {
        if (root == nullptr) {
            return 0;
        }
        int left = max(0, branchSum(root->left, maxWithTop));
        int right = max(0, branchSum(root->right, maxWithTop));
        maxWithTop = max(maxWithTop, left + right + root->val);
        return max(left, right) + root->val;
    }
};
