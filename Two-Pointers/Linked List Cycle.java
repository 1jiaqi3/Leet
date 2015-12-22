//Given a linked list, determine if it has a cycle in it.

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
    public boolean hasCycle(ListNode head) {
        ListNode pointer1=head;
        ListNode pointer2=head;
        while(pointer2!=null&&pointer2.next!=null){
            pointer1=pointer1.next;
            pointer2=pointer2.next.next;
            if(pointer1==pointer2){
                return true;
            }
        }
        return false;
    }
}
