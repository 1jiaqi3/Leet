//Sort a linked list using insertion sort.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode pointer = dummy;
            while (pointer.next != null && pointer.next.val < head.val) {
                pointer = pointer.next;
            }
            ListNode tmp = head.next;
            head.next = pointer.next;
            pointer.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}
