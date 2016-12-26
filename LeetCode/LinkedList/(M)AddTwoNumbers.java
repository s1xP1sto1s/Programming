/*
2. Add Two Numbers
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
给的数字就是逆序的，刚好可以从个位开始加
最后结果要求是逆序的
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode(0);
        while(l1!=null || l2!=null){
            int val1 = l1==null?0:l1.val;
            int val2 = l2==null?0:l2.val;
            int temp = val1+val2+flag;
            ListNode node = new ListNode(temp%10);
            if(temp>=10)
                flag = 1;
            else
                flag = 0;
            
            ListNode tmp = head.next;
            head.next = node;
            node.next = tmp;
            
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        if(flag==1){
            head.val = 1;
            return getReverse(head);
        }
        else{
            return getReverse(head.next);
        }
    }
    public ListNode getReverse(ListNode head){
        ListNode back = head;
        ListNode forward = head.next;
        back.next = null;
        while(forward!=null){
            ListNode tmp = forward.next;
            forward.next = back;
            back = forward;
            forward = tmp;
        }
        return back;
    }
}
