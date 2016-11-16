/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Given inorder and postorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0)
            return null;
        return buildTreeHelper(inorder,postorder,0,postorder.length-1,0,inorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] inorder,int[] postorder,int posLeft,int posRight,int inLeft,int inRight)
    {
        if(posRight<posLeft)
            return null;
        int rootVal = postorder[posRight];
        TreeNode root = new TreeNode(rootVal);
        
        int index = findIndex(inorder,rootVal);
        int numLeft = index-inLeft;
        int numRight = inRight-index;
        
        root.right = buildTreeHelper(inorder,postorder,posRight-numRight,posRight-1,index+1,inRight);
        root.left = buildTreeHelper(inorder,postorder,posLeft,posRight-numRight-1,inLeft,index-1);
        return root;
    }
    public int findIndex(int[] inorder,int val)
    {
        int index = 0;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==val)
            {
                index = i;
                break;
            }
        }
        return index;
    }
}
