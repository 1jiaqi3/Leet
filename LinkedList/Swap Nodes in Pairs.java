/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode p1 = head;
            ListNode p2 = head.next;
            head = head.next;
            while (p1 != null && p2 != null) {
                ListNode p0 = p1;
                p1.next = p2.next;
                p2.next = p1;
                p1 = p1.next;
                p2 = p1 == null ? null : p1.next;
                p0.next = p2 == null ? p1 : p2;
            }
            return head;
        }
    }
}
