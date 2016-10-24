/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/
/*
使用递归求解，明确返回值类型：包含当前根节点到叶子节点的所有路径的List<String>
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ltmp = new ArrayList<String>(); 
        if(root==null)
            return ltmp;
        if(root.left==null && root.right==null)
        {
            ltmp.add(root.val+"");
            return ltmp;
        }
        List<String> listLeft = binaryTreePaths(root.left);
        for(String str:listLeft)
            ltmp.add(root.val+"->"+str);
        List<String> listRight = binaryTreePaths(root.right);
        for(String str:listRight)
            ltmp.add(root.val+"->"+str);
        return ltmp;
    }
}
