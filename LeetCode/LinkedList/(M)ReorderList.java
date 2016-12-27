/*
143. Reorder List
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head2 = getReverse(walker.next);
        walker.next = null;
        ListNode head1 = head;
        while(head2!=null){
			ListNode temp1 = head1.next;
			ListNode temp2 = head2.next;
			head1.next = head2;
			head2.next = temp1;
			head1 = temp1;
			head2 = temp2;
        }
    }
    public ListNode getReverse(ListNode head){
        if(head==null)
            return head;
        ListNode back = head;
        ListNode forward = head.next;
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
