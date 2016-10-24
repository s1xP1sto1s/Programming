/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/
/*
用递归求解：
此时树要分两种情况：
1、当前树还没有左叶子节点，那么当前树的左叶子节点值的和应该=左子树左叶子节点值的和+右子树左叶子节点的和
2、当前树出现了左叶子节点，那么当前树左叶子节点值的和应该=左叶子节点值+右子树左叶子节点的和
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left!=null && root.left.left==null && root.left.right==null)
            return root.left.val + sumOfLeftLeaves(root.right);
        else 
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
