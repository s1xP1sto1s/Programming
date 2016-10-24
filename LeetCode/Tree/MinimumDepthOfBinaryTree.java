/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/
/*
注意：节点有三种情况
分别是：既有左子树又有右子树，没有左子树，没有右子树。
三种情况最小深度的计算方式不同。
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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null)
            return minDepth(root.right)+1;
        else if(root.right==null)
            return minDepth(root.left)+1;
        else
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
