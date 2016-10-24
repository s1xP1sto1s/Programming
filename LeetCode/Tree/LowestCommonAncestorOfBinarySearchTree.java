/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as 
the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
since a node can be a descendant of itself according to the LCA definition.
*/
/*
找二叉搜索树中两个节点的最小公共父节点。
思路：分别记录下从根节点开始到两个节点的路径，在两个路径中反向寻找。
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        String[] str1 = find(root,p).split(" ");
        String[] str2 = find(root,q).split(" ");
        int val = str1.length>str2.length?findLCA(str2,str1):findLCA(str1,str2);
        return findNode(root,val);
    }
    public String find(TreeNode root,TreeNode p)
    {
        if(root==null)
            return "";
        if(p.val<root.val)
            return root.val+" "+find(root.left,p);
        else if(p.val>root.val)
            return root.val+" "+find(root.right,p);
        else 
            return root.val+"";
    }
    public int findLCA(String[] shortStr,String[] longStr)
    {
        for(int i=shortStr.length-1;i>=0;i--)
        {
            for(int j=longStr.length-1;j>=0;j--)
            {
                if(shortStr[i].equals(longStr[j]))
                    return Integer.parseInt(shortStr[i]);
            }
        }
        return Integer.parseInt(shortStr[0]);
    }
    public TreeNode findNode(TreeNode root,int val)
    {
        if(root==null)
            return null;
        if(val>root.val)
            return findNode(root.right,val);
        else if(val<root.val)
            return findNode(root.left,val);
        else 
            return root;
    }
}
