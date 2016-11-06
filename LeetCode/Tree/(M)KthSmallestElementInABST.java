/*
230. Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?
Hint:
Try to utilize the property of a BST.
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
 /*
 找到最小的，然后将最小的删除，循环k-1次，第k次找最小的即为Kth smallest
 注意BST中的删除操作！！！
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        for(int i=0;i<k-1;i++)
        {
            TreeNode smallest = findSmallest(root);
            root = deleteSmallest(root,smallest);
        }
        return findSmallest(root).val;
    }
    public TreeNode findSmallest(TreeNode root)
    {
        if(root.left==null)
            return root;
        return findSmallest(root.left);
    }
    public TreeNode deleteSmallest(TreeNode root,TreeNode smallest)
    {
        if(root.val>smallest.val)
            root.left = deleteSmallest(root.left,smallest);
        else
        {
            if(root.right!=null)
                root = root.right;
            else
                root = null;
        }
        return root;
    }
}
