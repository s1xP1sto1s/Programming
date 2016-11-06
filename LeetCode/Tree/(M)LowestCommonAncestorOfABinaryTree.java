/*
236. Lowest Common Ancestor of a Binary Tree
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the
lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, 
since a node can be a descendant of itself according to the LCA definition.
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
        Map<TreeNode,TreeNode> map = new HashMap<TreeNode,TreeNode>();
        map.put(root,null);
        find(map,root,p);
        find(map,root,q);
        
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        list1.add(p);
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        list2.add(q);
        TreeNode parent1 = map.get(p);
        while(parent1!=null)
        {
            list1.add(parent1);
            parent1 = map.get(parent1);
        }
        TreeNode parent2 = map.get(q);
        while(parent2!=null)
        {
            list2.add(parent2);
            parent2 = map.get(parent2);
        }
        
        for(int i=0;i<=list1.size();i++)
        {
            if(list2.contains(list1.get(i)))
                return list1.get(i);
        }
        return null;
    }
    public void find(Map<TreeNode,TreeNode> map,TreeNode root,TreeNode target)
    {
        if(root.val==target.val)
            return;
        if(root.left!=null)
        {
            map.put(root.left,root);
            find(map,root.left,target);
        }
        if(root.right!=null)
        {
            map.put(root.right,root);
            find(map,root.right,target);
        }
    }
}
