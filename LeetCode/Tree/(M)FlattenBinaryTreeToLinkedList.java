/*
114. Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
    public TreeNode flattenHelper(TreeNode root)
    {
        if(root==null)
            return null;
        TreeNode flattenLeft = flattenHelper(root.left);
        TreeNode flattenRight = flattenHelper(root.right);
        
        if(flattenLeft!=null)
        {
            TreeNode last = findLast(flattenLeft);
            root.left = null;
            root.right = flattenLeft;
            last.right = flattenRight;
        }
        else
            root.right = flattenRight;
        return root;
    }
    public TreeNode findLast(TreeNode root)
    {
        if(root==null)
            return null;
        if(root.right!=null)
            return findLast(root.right);
        else 
            return root;
    }
}
