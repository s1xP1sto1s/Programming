/*
129. Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        List<TreeNode> leaves = new ArrayList<TreeNode>();
        findLeaves(root,leaves);
        List<String> sums = new ArrayList<String>();
        for(int i=0;i<leaves.size();i++)
            sums.add(findPath(root,leaves.get(i)));
        int sum = 0;
        for(String str:sums)
            sum += Integer.parseInt(str);
        return sum;
    }
    public void findLeaves(TreeNode root,List<TreeNode> list)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            list.add(root);
        findLeaves(root.left,list);
        findLeaves(root.right,list);
    }
    public String findPath(TreeNode root,TreeNode leaf)
    {
        if(root==null)
            return "NO";
        if(root==leaf)
            return leaf.val+"";
        String leftStr = root.val+findPath(root.left,leaf);
        if(!leftStr.contains("NO"))
            return leftStr;
        else
            return root.val+findPath(root.right,leaf);
    }

}
