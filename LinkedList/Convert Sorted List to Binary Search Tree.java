//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        return convert(head);
    }
    public TreeNode convert(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        } else {
            ListNode fast = head;
            ListNode slow = head;
            ListNode tmp = null;
            while (fast != null && fast.next != null) {
                tmp = slow;
                fast = fast.next.next;
                slow = slow.next;
            }
            TreeNode root = new TreeNode(slow.val);
            tmp.next = null;
            root.right = convert(slow.next);
            root.left = convert(head);
            return root;
        }
    }
}
