/*
445. Add Two Numbers II
You are given two linked lists representing two non-negative numbers. The most significant digit comes first 
and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
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
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode ln = len1>=len2?l1:l2;
        ListNode reverseHead = ln;
        int flag = 0;
        while(l1!=null && l2 !=null){
            int temp = l1.val+l2.val+flag;
            if(temp>=10){
                flag = 1;
                ln.val = temp%10;
            }
            else{
                flag = 0;
                ln.val = temp;
            }
            l1 = l1.next;
            l2 = l2.next;
            ln = ln.next;
        }
        while(ln!=null && flag==1){
            int temp = ln.val +flag;
            if(temp>=10){
                ln.val = temp%10;
                flag = 1;
            }
            else{
                ln.val = temp;
                flag = 0;
            }
            ln = ln.next;
        }
        ListNode head = reverse(reverseHead);
        if(ln==null && flag==1){
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
    
    public ListNode reverse(ListNode head){
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
    public int getLength(ListNode head){
        int length = 1;
        while(head.next!=null){
            length++;
            head = head.next;
        }
        return length;
    }
}
