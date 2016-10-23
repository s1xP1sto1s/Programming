/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
*/
/*
首先因为开始节点和结束节点都可以是根节点或者是叶子节点，没有限制。
所以我们需要一个函数findPath来计算从当前根节点起，有几个能够满足要求的。
明确返回值类型！！！findPath函数返回类型是满足要求的路径的个数！！！
递归求解！！！
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
    public int pathSum(TreeNode root, int sum) {
        if(root==null)
            return 0;
        return findPath(root,sum,0) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    public int findPath(TreeNode root,int sum,int sumTemp)
    {
        if(root==null)
            return 0;
        int count = 0;
        if((sumTemp+root.val)==sum)
            count++;
        count += findPath(root.left,sum,sumTemp+root.val) + findPath(root.right,sum,sumTemp+root.val);
        return count;
    }
}
