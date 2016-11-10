/*
222. Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes 
inclusive at the last level h.
*/
/*
直接遍历的话，时间复杂度为O(N),超时。
利用满二叉树的特点：如果一棵树是满二叉树，节点总数=2^H-1。
递归：是满二叉树？返回节点总数：递归左子树与右子树+1。
时间复杂度：T(N) = 2T(N/2)+O(logN);
推出：T(N) = O((logN)^2)
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
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int leftLevel = findLeftLevel(root);
        int rightLevel = findRightLevel(root);
        if(leftLevel==rightLevel)
            return (1<<leftLevel)-1;
        else 
            return countNodes(root.left)+countNodes(root.right)+1;
        
    }
    public int findRightLevel(TreeNode root)
    {
        if(root==null)
            return 0;
        return findRightLevel(root.right)+1;   
    }
    public int findLeftLevel(TreeNode root)
    {
        if(root==null)
            return 0;
        return findLeftLevel(root.left)+1;
    }
}
