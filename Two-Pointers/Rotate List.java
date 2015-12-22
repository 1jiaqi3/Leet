//Given a list, rotate the list to the right by k places, where k is non-negative.

//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        int count=0;
        for(ListNode tmp=head;tmp!=null;tmp=tmp.next)
        count++;
        if(k%count==0) return head;
        for(int i=0;i<k%count;i++)
        fast=fast.next;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode newHead=slow.next;
        fast.next=head;
        slow.next=null;
        return newHead;
    }
}
