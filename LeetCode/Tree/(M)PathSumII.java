/*
113. Path Sum II
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
/*
DFS：使用一个list来记录当前路径,原路返回时删除当前深度的元素。
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> currentRes = new LinkedList<Integer>(); 
        findPath(root,sum,res,currentRes);
        return res;
    }
    public void findPath(TreeNode root,int sum,List<List<Integer>> res,LinkedList<Integer> currentRes)
    {
        if(root==null)
            return;
        currentRes.add(root.val);
        if(root.val==sum && root.left==null && root.right==null)
            res.add(new LinkedList<Integer>(currentRes));
            //Attention!!!
        findPath(root.left,sum-root.val,res,currentRes);
        findPath(root.right,sum-root.val,res,currentRes);
        currentRes.removeLast();
    }
}
