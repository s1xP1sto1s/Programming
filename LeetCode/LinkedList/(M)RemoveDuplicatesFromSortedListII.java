/*
82. Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = newHead.next;
        int flag = 0;
        while(cur!=null){
            if(cur.next!=null && cur.next.val==cur.val){
                cur = cur.next;
                flag = 1;
            }
            else{
                if(flag==1){
                    flag = 0;
                    pre.next = cur.next;
                    cur = cur.next;
                }
                else{
                    cur = cur.next;
                    pre = pre.next;
                }
            }
        }
        return newHead.next;
    }
}
/*********************************************************************************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = newHead.next;
        while(cur!=null){
            if(cur.next!=null && cur.next.val==cur.val){
                cur = cur.next;
            }
            else{
                if(pre.next==cur){
                    pre = pre.next;
                    cur = cur.next;
                }
                else{
                    pre.next = cur.next;
                    cur = cur.next;
                }
            }

        }
        return newHead.next;
    }
}
