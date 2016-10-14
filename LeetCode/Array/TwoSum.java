/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
/**************************Runtime 56ms*********************/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] ret = new int[2];
        for(int i=0; i<len-1; i++)
        {
            for(int j=i+1; j<len; j++)
            {
                if((nums[i]+nums[j])==target)
                {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
    }
}
/****************************Runtime 10ms************************/
/*
使用HashMap实现，注意HashMap中需要保证键的唯一性，put()方法出现相同键时，用后者的值覆盖前者
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(target-nums[i])&&(hm.get(target-nums[i])!=i))
                return new int[]{i,hm.get(target-nums[i])};
        }
        return new int[]{0};
    }
}
