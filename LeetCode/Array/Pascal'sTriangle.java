/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
//注意不用考虑空格，并不是要打印出这种形式。注意每一个row的元素与前一row的关系即可

public class Solution {
    
    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0)
            return list;
        for(int i=0; i<numRows; i++)
        {
            List<Integer> al = new ArrayList<Integer>();
            addElement(al,i+1);
            list.add(al);
        }
        return list;
    }
    private void addElement(List<Integer> al,int rowNum)
    {
        al.add(1);
        if(rowNum>2)
        {
            List<Integer> temp = list.get(rowNum-2);
            for(int i=1; i<rowNum-1; i++)
            {
                al.add((temp.get(i)+temp.get(i-1)));
            }
        }
        if(rowNum>1)
            al.add(1);
    }
}
