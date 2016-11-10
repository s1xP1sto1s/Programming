/*
199. Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes 
you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/
/*
层序遍历即可求解
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 1;
        while(count!=0)
        {
            int temp = count;
            count = 0;
            for(int i=0;i<temp;i++)
            {
                TreeNode tn = queue.removeFirst();
                if(i==(temp-1))
                    list.add(tn.val);
                if(tn.left!=null)
                {
                    queue.add(tn.left);
                    count++;
                }
                if(tn.right!=null)
                {
                    queue.add(tn.right);
                    count++;
                }
            }
        }
        return list;
    }
}
