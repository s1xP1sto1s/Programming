/*
449. Serialize and Deserialize BST
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be 
stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same 
or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized 
to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be
stateless.
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
 /*
 注意：BST节点的取出方式对最后能否通过插入方式成功构建BST有影响
 采用层序遍历取出！！！但是运行时间在300ms，能否改进？
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String str = "";
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root==null)
            return str;
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode tn = queue.removeFirst();
            str = str+" "+tn.val;
            if(tn.left!=null)
                queue.add(tn.left);
            if(tn.right!=null)
                queue.add(tn.right);
        }
        return str.trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("".equals(data))
            return null;
        String[] str = data.split(" ");
        TreeNode tn = null;
        for(int i=0;i<str.length;i++)
            tn = insert(tn,Integer.parseInt(str[i]));
        return tn;
    }
    public TreeNode insert(TreeNode root,int val)
    {
        if(root==null)
            return new TreeNode(val);
        if(val>root.val)
            root.right = insert(root.right,val);
        else 
            root.left = insert(root.left,val);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
