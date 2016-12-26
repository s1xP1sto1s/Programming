/*
92. Reverse Linked List II
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //多增加一个节点作为头结点，以便记下开始反转的节点之前节点的引用
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        int tmp = m;
        while(--tmp!=0)
            pre = pre.next;
        ListNode back = pre.next;
        ListNode forward = back.next;
        int val = n-m;
        while(--val>=0){
            ListNode temp = forward.next;
            forward.next = back;
            back = forward;
            forward = temp;
        }
        pre.next.next = forward;
        pre.next = back;
        return newHead.next;
    }
}
