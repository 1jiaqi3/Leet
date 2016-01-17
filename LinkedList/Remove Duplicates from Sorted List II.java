/**
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
**/
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
        if(head == null) return null;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode prev = dum;
        ListNode cur = head;
        while(cur != null){
            int curVal = cur.val;
            if(cur.next != null && cur.val == cur.next.val){
                while(cur != null && cur.val == curVal){
                    cur = cur.next;
                }
                prev.next = cur;
            }
            else{
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dum.next;
    }
}
