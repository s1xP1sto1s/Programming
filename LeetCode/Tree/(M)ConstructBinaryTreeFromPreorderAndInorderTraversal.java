/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.
*/
/*
迭代：返回是根据当前结果构造好的树的根节点的引用
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0)
            return null;
        return buildTreeHelper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode buildTreeHelper(int[] preorder,int[] inorder,int preLeft,int preRight,int inLeft,int inRight)
    {
        if(preRight==preLeft || inRight==inLeft)
            return new TreeNode(preorder[preLeft]);
        if(preRight<preLeft || inRight<inLeft)
            return null;
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = findIndex(inorder,rootVal);
        
        int leftNum = rootIndex-inLeft;
        int rightNum = inRight-rootIndex;
        
        root.left = buildTreeHelper(preorder,inorder,preLeft+1,preLeft+leftNum,inLeft,rootIndex-1);
        root.right = buildTreeHelper(preorder,inorder,preLeft+leftNum+1,preRight,rootIndex+1,inRight);
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
