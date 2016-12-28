/*
147. Insertion Sort List
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        while(cur!=null){
            while(pre.next!=null && pre.next.val<cur.val){
                pre = pre.next;
            }
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = newHead;
            cur = next;
        }
        return newHead.next;
    }
}
