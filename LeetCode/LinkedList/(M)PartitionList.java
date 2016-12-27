/*
86. Partition List
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 通过堆栈可以实现
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        LinkedList<Integer> less = new LinkedList<Integer>();
        LinkedList<Integer> greater = new LinkedList<Integer>();
        while(head!=null){
            if(head.val<x)
                less.addLast(head.val);
            else
                greater.addLast(head.val);
            head = head.next;
        }
        
        ListNode lessLast = null;
        ListNode tempHead = null;
        if(less.peekLast()!=null){
            lessLast = new ListNode(less.pollLast());
            tempHead = lessLast;
            while(less.peekLast()!=null){
                ListNode temp = new ListNode(less.pollLast());
                temp.next = tempHead;
                tempHead = temp;
            }
        }
        ListNode tempHead2 = null;
        if(greater.peekLast()!=null){
            while(greater.peekLast()!=null){
                ListNode temp = new ListNode(greater.pollLast());
                temp.next = tempHead2;
                tempHead2 = temp;
            }
        }

        if(lessLast!=null){
            lessLast.next = tempHead2;
            return tempHead;
        }
        else{
            return tempHead2;
        }
        
    }
}
