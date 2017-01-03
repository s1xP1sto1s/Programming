/*
136. Single Number
Given an array of integers, every element appears twice except for one. Find that single one.
*/
/****************************Solution1**********************/
public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        for(Map.Entry<Integer,Integer> me:map.entrySet()){
            if(me.getValue()==1)
                return me.getKey();
        }
        return 0;
    }
}
/***************************Solution2*********************/
/*
利用异或运算
0^N = N
N^N = 0
异或运算是满足交换律的
题目可以转化为：
0^(N1^N1)^(N2^N2)^......^N
=0^N=N
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }
}
