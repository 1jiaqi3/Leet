/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        //Best Solution without using extra buffer (Hashtable)
        //If the list is unsorted, runs in O(n^2) time
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        while (pointer2 != null) {
            while (pointer2 != null && pointer2.val == pointer1.val) {
                pointer2 = pointer2.next;
            }
            pointer1.next = pointer2;
            pointer1 = pointer2;
            if (pointer2 != null) {
                pointer2 = pointer2.next;
            }
        }
        return head;
    }
}
