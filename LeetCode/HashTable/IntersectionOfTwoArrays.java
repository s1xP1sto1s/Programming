/*
349. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }
        Iterator<Integer> it = set1.iterator();
        while(it.hasNext()){
            int temp = it.next();
            if(set2.contains(temp))
                list.add(temp);
        }
        Integer[] res = list.toArray(new Integer[0]);
        int[] result = new int[res.length];
        for(int i=0;i<res.length;i++)
            result[i] = res[i];
        return result;
    }
}
