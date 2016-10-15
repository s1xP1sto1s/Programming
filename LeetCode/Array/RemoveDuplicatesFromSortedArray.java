/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
*/
/*******************************Runtime 244ms**********************************/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int index = 0;
        while(true)
        {
            if(index!=nums.length)
            {
                index = findIndex(nums,start);
                remove(nums,start,index);
                start++;
            }
            else
            {
                return start;
            }
        }
    }
    private int findIndex(int[]nums, int start)
    {
        int temp = nums[start];
        while((start<nums.length)&&(nums[start]==temp))
        {
            start++;
        }
        return start;
    }
    private void remove(int[]nums, int start, int index)
    {
        int temp = nums[nums.length-1];
        for(int i=start+1; (i+index-start-1)<nums.length; i++)
        {
            nums[i] = nums[i+index-start-1];
        }
        for(int i=nums.length-(index-start-1); i<nums.length; i++)
        {
        	nums[i] = temp;
        }
    }
}
