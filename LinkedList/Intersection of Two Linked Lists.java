/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        for (ListNode p = headA; p != null; p = p.next) {
            lenA++;
        }
        int lenB = 0;
        for (ListNode p = headB; p != null; p = p.next) {
            lenB++;
        }
        ListNode longer = headA;
        ListNode shorter = headB;
        if (lenA < lenB) {
            longer = headB;
            shorter = headA;
        }
        int diff = Math.abs(lenA - lenB);
        for (int i = 1; i <= diff; i++) {
            longer = longer.next;
        }
        while (longer != null) {
            if (longer == shorter) {
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }
}
