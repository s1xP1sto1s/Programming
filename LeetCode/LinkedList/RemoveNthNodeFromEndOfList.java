/*
19. Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //back指向要删除的元素的前一个元素
        ListNode back = head;
        //当forward.next==null时，back指针刚好指向要删除的元素
        ListNode forward = head;
        while(n--!=0){
            forward = forward.next;
        }
        //如果forward==null，说明要删除的是头元素
        if(forward==null)
            head = back.next;
        else{
            //寻找要删除的元素的前一个元素
            while(forward.next!=null){
                forward = forward.next;
                back = back.next;
            }
            //执行删除
            back.next = back.next.next;
        }
        return head;
    }
}
