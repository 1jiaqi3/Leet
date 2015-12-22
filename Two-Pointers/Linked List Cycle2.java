//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

//Note: Do not modify the linked list.

//Follow up:
//Can you solve it without using extra space?
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode pointer1=head;
        ListNode pointer2=head;
        while(pointer2!=null&&pointer2.next!=null){
            pointer1=pointer1.next;
            pointer2=pointer2.next.next;
            if(pointer1==pointer2){
                pointer1=head;
                break;
            }
        }
        if(pointer2==null||pointer2.next==null){
            return null;
        }
        while(pointer1!=pointer2){
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }
        return pointer1;
    }
