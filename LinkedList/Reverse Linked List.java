//Reverse a singly linked list.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null)
        return head;
        //get second node    
        ListNode second = head.next;
        //set first's next to be null
        head.next = null;
        ListNode rest = reverseList(second);
        second.next = head;
        return rest;
    }
}
