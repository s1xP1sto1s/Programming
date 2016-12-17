/*
203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/
/*
注意：要删除一个节点，就必须记住这个节点前一个节点的应用，
如果采用ListNode forward = head.next
       ListNode back = head;
       的方式，对于连续出现要删除的元素时将束手无策，如[1,1,2,2,3]
所以用额外的O(1)的空间，新建一个头结点realhead指向head便可实现。时间复杂度为O(N)
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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode realhead = new ListNode(0);
        realhead.next = head;
        ListNode forward = head;
        ListNode back = realhead;

        while(forward!=null){
            if(forward.val==val){
                back.next = forward.next;
                forward = forward.next;
            }
            else{
                back = back.next;
                forward = forward.next;
            }
        }
        return realhead.next;
    }
}
