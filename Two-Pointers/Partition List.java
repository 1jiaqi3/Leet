//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

//You should preserve the original relative order of the nodes in each of the two partitions.

//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode lessThan=null;
        ListNode lessScan=null;
        ListNode greaterOrEqual=null;
        ListNode greaterScan=null;
        while(head!=null){
            if(head.val<x){
                ListNode newNode=new ListNode(head.val);
                if(lessThan==null){
                    lessThan=newNode;
                    lessScan=lessThan;
                }
                else{
                    lessScan.next=newNode;
                    lessScan=newNode;
                }
            }
            else{
                ListNode newNode=new ListNode(head.val);
                if(greaterOrEqual==null){
                    greaterOrEqual=newNode;
                    greaterScan=greaterOrEqual;
                }
                else{
                    greaterScan.next=newNode;
                    greaterScan=newNode;                    
                }
            }
            head=head.next;
        }
        if(lessScan==null) return greaterOrEqual;
        lessScan.next=greaterOrEqual;
        return lessThan;
    }
}
