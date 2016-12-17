/*
234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.
Could you do it in O(n) time and O(1) space?
*/
/*
判断一个链表正序和反序是否相等。
注意：不能单纯地将原链表反序然后比较，因为空间复杂度为O(1)的条件下无法实现。
思考:一个链表的组成为[a[正],b[正]]，其反序表示为[b[反],a[反]]。
我们需要验证的是a[正]=b[反]并且b[正]=a[反],实际上验证一边已经足够。
因此空间复杂度可以保证为O(1)
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
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        ListNode temp = head;
        //计算长度
        int length = getLength(temp);
        if(length==1)
            return true;
        //找反序的起始节点
        ListNode reverseHead = head;
        for(int i=length/2;i>0;i--)
            reverseHead = reverseHead.next;
        if(length%2==1)
            reverseHead = reverseHead.next;
        //将其反序
        reverseHead = getReverse(reverseHead);
        //比较
        while(reverseHead!=null){
            if(head.val==reverseHead.val){
                head = head.next;
                reverseHead = reverseHead.next;
            }
            else
                return false;
        }
        return true;
    }
    public ListNode getReverse(ListNode head){
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
            head = head.next;
            length++;
        }
        return length;
    }
}
