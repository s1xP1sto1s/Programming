/*
21. Merge Two Sorted Lists
Merge two sorted linked lists and return it as a new list. The new list should be 
made by splicing together the nodes of the first two lists
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 注意：操作的是引用
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode last = head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                last.next = l1;
                last = l1;
                l1 = l1.next;
            }
            else{
                last.next = l2;
                last = l2;
                l2 = l2.next;
            }
        }
        if(l1!=null)
            last.next = l1;
        if(l2!=null)
            last.next = l2;
        return head.next;

    }
}
