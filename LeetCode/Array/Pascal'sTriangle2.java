/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

public class Solution {
    private List<List<Integer>> list = new ArrayList<List<Integer>>();
    public List<Integer> getRow(int rowIndex) {
        createRow(rowIndex);
        return list.get(rowIndex);       
    }
    public void createRow(int rowIndex)
    {
        for(int i=0; i<=rowIndex; i++)
        {
            List<Integer> temp = new ArrayList<Integer>();
            addElements(temp,i);
            list.add(temp);
        }
    }
    private void addElements(List<Integer> row, int rowNum)
    {
        row.add(1);
        if(rowNum>=2)
        {
            List<Integer> temp = list.get(rowNum-1);
            for(int i=1; i<rowNum; i++)
            {
                row.add((temp.get(i)+temp.get(i-1)));
            }
        }
        if(rowNum>=1)
            row.add(1);
    }
}
