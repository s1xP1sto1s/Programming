/*
24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode back = head;
        ListNode forward = head.next;
        ListNode newHead = forward;
        while(forward!=null){
            ListNode temp = forward.next;
            //一般情况
            if(temp!=null && temp.next!=null){
                forward.next = back;
                back.next = temp.next;
                back = temp;
                forward = temp.next;
            }
            //双数个数的结尾情况
            else if(temp==null){
                forward.next = back;
                back.next = temp;
                break;
            }
            //单数个数的结尾情况
            else if(temp!=null && temp.next==null){
                forward.next = back;
                back.next = temp;
                break;
            }
        }
        return newHead;
    }
}
