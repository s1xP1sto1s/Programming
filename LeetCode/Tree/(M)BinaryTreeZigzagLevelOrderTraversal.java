/*
103. Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null)
            return res;
        queue.add(root);
        int count = 1;
        boolean flag = false;
        while(count!=0)
        {
            int temp = count;
            count = 0;
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<temp;i++)
            {
                if(!flag)
                {//如果是顺序，flag=false
                    TreeNode tn = queue.removeFirst();
                    list.add(tn.val);
                    count += addChild(queue,tn,flag);
                }
                else
                {
                    TreeNode tn = queue.removeLast();
                    list.add(tn.val);
                    count += addChild(queue,tn,flag);
                }
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
    public static int addChild(LinkedList<TreeNode> queue,TreeNode tn,boolean flag)
    {
        int count = 0;
        if(!flag)
        {//如果是顺序,flag=false
	        if(tn.left!=null)//左儿子先进，右儿子后进
	        {
	            queue.addLast(tn.left);//removeFirst()对应addLast(),队列的头和尾
	            count++;
	        }
	        if(tn.right!=null)
	        {
	            queue.addLast(tn.right);
	            count++;
	        }
        }
        else
        {//如果是逆序，falg=true
        	if(tn.right!=null)//右儿子先进，左儿子后进
        	{
        		queue.addFirst(tn.right);//removeLast()对应addFirst(),队列的头和尾
        		count++;
        	}
        	if(tn.left!=null)
        	{
        		queue.addFirst(tn.left);
        		count++;
        	}
        }
        return count;
    }
}
