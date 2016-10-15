/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
such that nums[i] = nums[j] and the difference between i and j is at most k.
*/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(!hasDuplicate(nums))
            return false;
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    if((j-i)<=k)
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean hasDuplicate(int nums[])
    {
        Set<Integer> hs = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
            hs.add(nums[i]);
        return hs.size()!=nums.length;
    }
}
