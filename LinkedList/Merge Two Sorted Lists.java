//Merge two sorted linked lists and return it as a new list. 
//The new list should be made by splicing together the nodes of the first two lists.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummyHead=new ListNode(0);
        ListNode p=dummyHead;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                p.next=l1;
                l1=l1.next;
            }
            else if(l2.val<l1.val){
                p.next=l2;
                l2=l2.next;
            }
            p=p.next;
        }
        if(l1==null){
            p.next=l2;
        }
        else if(l2==null){
            p.next=l1;
        }
        return dummyHead.next;
    }
}