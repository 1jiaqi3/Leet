/**
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode p1=head;
        ListNode p2=head.next;
        while(p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        p2=p1.next;
        p1.next=null;
        p2=reverse(p2);
        head=merge(head,p2);
        return;
    }
    public ListNode reverse(ListNode head){
        ListNode dum=new ListNode(0);
        dum.next=head;
        ListNode p=head;
        while(p.next!=null){
            ListNode p1=p.next;
            p.next=p1.next;
            p1.next=dum.next;
            dum.next=p1;
        }
        return dum.next;
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode newHead=l1;
        ListNode p=newHead;
        l1=l1.next;
        while(l2.next!=null){
            p.next=l2;
            p=p.next;
            l2=l2.next;
            p.next=l1;
            p=p.next;
            l1=l1.next;
        }
        p.next=l2;
        if(l1!=null){
            p.next.next=l1;
        }
        return newHead;
    }
}
