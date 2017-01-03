/*
350. Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        for(int i=0;i<nums1.length;i++){
            if(map1.containsKey(nums1[i]))
                map1.put(nums1[i],map1.get(nums1[i])+1);
            else
                map1.put(nums1[i],1);
        }
        for(int i=0;i<nums2.length;i++){
            if(map2.containsKey(nums2[i]))
                map2.put(nums2[i],map2.get(nums2[i])+1);
            else
                map2.put(nums2[i],1);
        }
        List<Integer> list = new LinkedList<Integer>();
        for(Map.Entry<Integer,Integer> me:map1.entrySet()){
            if(map2.containsKey(me.getKey())){
                int temp = Math.min(me.getValue(),map2.get(me.getKey()));
                while(temp--!=0){
                    list.add(me.getKey());
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
