//Sort a linked list in O(n log n) time using constant space complexity.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
        while (fast != null && fast.next != null) {
            temp = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p1 = sortList(slow);
        temp.next = null;
        ListNode p2 = sortList(head);
        return merge(p1, p2);
    }
    public ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                pointer.next = p1;
                p1 = p1.next;
            } else {
                pointer.next = p2;
                p2 = p2.next;
            }
            pointer = pointer.next;
        }
        if (p1 == null) {
            pointer.next = p2;
        } else {
            pointer.next = p1;
        }
        return dummy.next;
    }
}
