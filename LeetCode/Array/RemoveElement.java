/*
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2
*/
/****************************2016.10.12*************************************/
//发现要删除的元素val，将该元素所在位置后面的元素前移，将遍历长度减1

public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
	int lenRe = 0;
        for(int i=0; i<len; i++)
        {
          if(nums[i]==val)
          {
            for(int j=i; j<len-1; j++)
            {
              nums[j] = nums[j+1];
            }
            i -= 1;
            lenRe += 1;
            len -=1;
          }
        }
	return (nums.length - lenRe);
    }
}
