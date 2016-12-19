/*
142. Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/
/*
设到相遇点时，walker走了s步，runner的速度是walker的两倍，那么runner走了2s步，设环的长度是r步，
那么有：2s=s+nr，即相遇时，runner除了走了walker的这s步以外，还走了n圈环。
设环的入口离起点a步，相遇点距离环的入口b步，那么有s=a+b，
则s=nr=a+b,a=(n-1)r+r-b,即从头开始到环的入口距离a步，等于从相遇点开始，走了(n-1)圈+(r-b)步，
即从第一次相遇点开始，newWalker从头结点开始，每次走一步，它们必定在环的入口相遇
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
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode walker = head;
        ListNode runner = head;
        while(walker.next!=null && runner.next!=null && runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner){
                ListNode newWalker = head;
                while(newWalker!=walker){
                    newWalker = newWalker.next;
                    walker = walker.next;
                }
                return walker;
            }
        }
        return null;
    }
}
