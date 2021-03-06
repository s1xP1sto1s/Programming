/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth 
of the two subtrees of every node never differ by more than 1.
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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int differ = findMaxDepth(root.left)-findMaxDepth(root.right);
        if(Math.abs(differ)>1)
            return false;
        else 
            return isBalanced(root.left) && isBalanced(root.right);
    }
    public int findMaxDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        return Math.max(findMaxDepth(root.left),findMaxDepth(root.right))+1;
    }
}
