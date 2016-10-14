/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
//每次都需要找数组中第一次出现0的索引，将非0数字与该索引对应的0交换
/********************************Runtime 16ms**********************************/
public class Solution {
    public void moveZeroes(int[] nums) {
        int indexZero = findIndex(nums);
        for(int i=indexZero; i<nums.length-1; i++)
        {
            if(nums[i]==0)
            {
                if(nums[i+1]!=0)
                {
                    int temp = nums[indexZero];
                    nums[indexZero] = nums[i+1];
                    nums[i+1] = temp;
                    indexZero = findIndex(nums);
                }
            }
        }
    }
    public int findIndex(int[] nums)
    {
        int indexZero = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==0)
            {
                indexZero=i;
                break;
            }
        }
        return indexZero;
    }
}
