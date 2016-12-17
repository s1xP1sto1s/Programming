/*
206. Reverse Linked List
Reverse a singly linked list.
*/
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
        if(head==null)
            return head;
        ListNode forward = head.next;
        ListNode back = head;
        back.next = null;
        while(forward!=null){
            ListNode temp = forward.next;
            forward.next = back;
            back = forward;
            forward = temp;
        }
        return back;
    }
}
