/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
*/

/*旋转数组，注意k可以大于n，每一步相当于将数组最右边的数移动到左边。经典的三步法！！*/
/*
结合规律找到一组k和n的分解点k%n，BA=(A'B')',符号'表示旋转。
*/

public class Solution {
    public void rotate(int[] nums, int k){
        int len = nums.length;
        k %= len;
        reverse(nums,0,len-k-1);
        reverse(nums,len-k,len-1);
        reverse(nums,0,len-1);
    }
    
    
    public void reverse(int[] nums, int start, int end){
        while(start<end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
