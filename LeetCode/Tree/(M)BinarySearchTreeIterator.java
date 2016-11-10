/*
173. Binary Search Tree Iterator
mplement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BSTIterator {
    private TreeNode root;
    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.root!=null;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode min = findMin(this.root);
        this.root = deleteMin(this.root,min);
        return min.val;
    }
    //返回删除最小节点之后根节点的引用
    private TreeNode findMin(TreeNode root)
    {
        if(root.left!=null)
            return findMin(root.left);
        else 
            return root;
    }
    private TreeNode deleteMin(TreeNode root,TreeNode min)
    {
        if(min.val<root.val)
            root.left = deleteMin(root.left,min);
        else
        {
            if(root.right!=null)
                root = root.right;
            else
                root = null;
        }
        return root;
    }

}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
