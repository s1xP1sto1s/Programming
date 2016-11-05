/*
 337. House Robber III 
 The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." 
 Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses 
 in this place forms a binary tree". It will automatically contact the police if two directly-linked houses 
 were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police. 
*/
/***********************************************************************/
//不能使用层序便利，因为小偷并不一定是隔一层抢一层
//层序的代码：
public class Solution {
    public int rob(TreeNode root) {
        int money1 = 0;
        int money2 = 0;
        boolean flag = false;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        if(root==null)
            return 0;
        list.add(root);
        int count = 1;
        while(count!=0)
        {
            int temp = count;
            for(int i=0;i<temp;i++)
            {
                TreeNode tn = list.removeFirst();
                count--;
                if(flag==true)
                    money1 += tn.val;
                else
                    money2 += tn.val;
                
                if(tn.left!=null)
                {
                    count++;
                    list.add(tn.left);
                }
                if(tn.right!=null)
                {
                    count++;
                    list.add(tn.right);
                }
            }
            flag = !flag;
        }
        return Math.max(money1,money2);
    }
}
/**********************************************************************************/
//递归求解：
/*
思路是：rob方法返回抢劫的最大值，这个最大值包括：1、抢劫当前节点得到的总抢劫值 与 2、不抢劫当前节点的总抢劫值 的最大值
即：Math.max(res[0],res[1])。其中res[contain,notcontain]为robHelper方法的返回值，即抢劫当前节点的总抢劫值contain
与不抢劫当前节点的总抢劫值notcontain。
contain：若要抢劫当前节点，那么当前节点的儿子节点就一定不能抢劫，即int contain = leftRes[1]+rightRes[1]+root.val
notcontain：若不抢劫当前节点，那么其儿子节点可以抢劫也可以不抢劫，
即int notcontain = Math.max(leftRes[0],leftRes[1])+Math.max(rightRes[0],rightRes[1]);
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
    public int rob(TreeNode root) {
        int[] res = robHelper(root);
        return Math.max(res[0],res[1]);
    }
    public int[] robHelper(TreeNode root)
    {
        if(root==null)
            return new int[]{0,0};
        int[] leftRes = robHelper(root.left);
        int[] rightRes = robHelper(root.right);
        int contain = leftRes[1]+rightRes[1]+root.val;
        int notcontain = Math.max(leftRes[0],leftRes[1])+Math.max(rightRes[0],rightRes[1]);
        return new int[]{contain,notcontain};
    }
}
