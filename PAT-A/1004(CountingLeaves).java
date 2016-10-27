/*
1004. Counting Leaves (30)
A family hierarchy is usually presented by a pedigree tree. Your job is to count those family members who have no child.
Input

Each input file contains one test case. Each case starts with a line containing 0 < N < 100, the number of nodes in a tree, 
and M (< N), the number of non-leaf nodes. Then M lines follow, each in the format:

ID K ID[1] ID[2] ... ID[K]
where ID is a two-digit number representing a given non-leaf node, K is the number of its children, followed by a sequence 
of two-digit ID's of its children. For the sake of simplicity, let us fix the root ID to be 01.
Output

For each test case, you are supposed to count those family members who have no child for every seniority level starting from the root.
The numbers must be printed in a line, separated by a space, and there must be no extra space at the end of each line.

The sample case represents a tree with only 2 nodes, where 01 is the root and 02 is its only child. Hence on the root 01 level,
there is 0 leaf node; and on the next level, there is 1 leaf node. Then we should output "0 1" in a line.

Sample Input
2 1
01 1 02
Sample Output
0 1
*/
/*
(1)使用儿子兄弟表示法建树
(2)使用层序遍历法(队列实现)数每一层有多少叶子节点
*/
import java.util.*;

public class Main {
  static class TreeNode
  {
    int number;
    TreeNode firstChild;
    TreeNode brother;
    TreeNode(int num)
    {
      number = num;
    }
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int nodeNum = sc.nextInt();
    TreeNode[] tn = new TreeNode[nodeNum];
    for(int i=0;i<nodeNum;i++)
      tn[i] = new TreeNode(i);
    
    int notLeaf = sc.nextInt();
    sc.nextLine();
    for(int i=0;i<notLeaf;i++)
    {
      int number = sc.nextInt();
      int childNum = sc.nextInt();
      int[] child = new int[childNum];
      for(int j=0;j<childNum;j++)
        child[j] = sc.nextInt();
      sc.nextLine();
      for(int k=0;k<child.length;k++)
      {
        if(k==0)
          tn[number-1].firstChild = tn[child[k]-1];
        if(k<child.length-1)
          tn[child[k]-1].brother = tn[child[k+1]-1];
      }
    }
    findLeaf(tn[0]);
  }

  public static void findLeaf(TreeNode root)
  {
    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    StringBuilder sb = new StringBuilder();
    list.add(root);
    int count = 1;
    while(count!=0)
    {
      int levelNum = 0;
      int temp = count;
      for(int i=0;i<temp;i++)
      {
        TreeNode tn = list.removeFirst();
        count--;
        if(tn.firstChild==null)
          levelNum++;
        else
        {
          list.add(tn.firstChild);
          count++;
          count += addBrother(tn.firstChild,list);
        }
      }
      sb.append(" "+levelNum);
    }
    System.out.println(sb.toString().trim());
  }
  public static int addBrother(TreeNode first,LinkedList<TreeNode> list)
  {
    if(first.brother!=null)
    {
      list.add(first.brother);
      return addBrother(first.brother,list)+1;
    }
    else
      return 0;
  }
}
