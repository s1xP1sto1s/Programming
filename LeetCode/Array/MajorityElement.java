/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    public int majorityElement(int[] nums) {
        int n = (int)Math.floor(nums.length/2);
        Integer[] elements = getElements(nums);
        for(int i=0;i<elements.length;i++)
        {
            if(count(nums,elements[i])>n)
                return elements[i];
        }
        return 0;
    }
    private Integer[] getElements(int[] nums)
    {
        Set<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
        }
        return hs.toArray(new Integer[hs.size()]);
    }
    private int count(int[] nums,int element)
    {
        int con = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==element)
                con++;
        }
        return con;
    }
}
