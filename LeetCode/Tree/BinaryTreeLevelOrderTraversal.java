/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/
/*
层序遍历 用队列可以实现，java中队列可以用LinkedList实现。add(),removeFirst()方法
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null)
            return list;
            
        queue.add(root);
        int count = 1;//count用于记录下一层的节点个数
        while(count!=0)
        {
            int temp = count;//temp用于循环将当前层的节点的val值放入al中
            List<Integer> al = new ArrayList<Integer>();
            for(int i=0;i<temp;i++)
            {
                TreeNode tn = queue.removeFirst();
                count--;
                if(tn.left!=null)
                {
                    queue.add(tn.left);
                    count++;//队列中进一个节点，下一层节点的个数+1；
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
        return list;
    }
}
