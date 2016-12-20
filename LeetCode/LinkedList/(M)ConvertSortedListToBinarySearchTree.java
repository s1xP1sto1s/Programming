/*
109. Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return toBSTHelper(head,null);
    }
    public TreeNode toBSTHelper(ListNode head,ListNode last){
        if(head==last)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=last && fast.next!=last){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBSTHelper(head,slow);
        root.right = toBSTHelper(slow.next,last);
        return root;
    }
}
