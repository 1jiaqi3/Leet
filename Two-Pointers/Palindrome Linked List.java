//Given a singly linked list, determine if it is a palindrome.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode newHead=head;
        newHead=reverse(newHead);
        for(;head!=null;head=head.next,newHead=newHead.next){
            if(head.val!=newHead.val) return false;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        if(head==null) return head;
        ListNode newHead=new ListNode(head.val);
        head=head.next;
        for(;head!=null;head=head.next){
            ListNode newNode=new ListNode(head.val);
            newNode.next=newHead;
            newHead=newNode;
        }
        return newHead;
    }
}
