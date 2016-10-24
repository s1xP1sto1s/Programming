/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, 
level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null)
            return list;
            
        queue.add(root);
        int count = 1;
        while(count!=0)
        {
            int temp = count;
            List<Integer> al = new ArrayList<Integer>();
            for(int i=0;i<temp;i++)
            {
                TreeNode tn = queue.removeFirst();
                count--;
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
                al.add(tn.val);
            }
            list.add(al);
        }
        List<List<Integer>> listRe = new ArrayList<List<Integer>>();
        for(int i=list.size()-1;i>=0;i--)
            listRe.add(list.get(i));
        return listRe;
    }
}
