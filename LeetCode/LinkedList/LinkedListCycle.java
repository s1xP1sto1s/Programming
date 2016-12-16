/*
141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

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
        if(head==null)
            return false;
        ListNode walker = head;
        ListNode runner = head;
        while(walker.next!=null && runner.next!=null && runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner)
                return true;
        }
        return false;
    }
}
