/*
Given an array of integers A and let n to be its length.

Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

Calculate the maximum value of F(0), F(1), ..., F(n-1).

Note:
n is guaranteed to be less than 105.

Example:

A = [4, 3, 2, 6]

F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
*/
/*****************************Runtime 589ms**********************************/
public class Solution {
    public int maxRotateFunction(int[] A) {
        int len = A.length;
        if(len<=1)
            return 0;        
        int[] sum = new int[len];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<len; i++)
        {
            sum[i] = computeSum(A);
            if(sum[i]>max)
                max = sum[i];
            rotateOne(A);
        }
        return max;
    }
    public int computeSum(int[] B)
    {
        int len = B.length;
        int sum = 0;
        for(int i=0; i<len; i++)
        {
            sum += B[i] * i;
        }
        return sum;
    }
    public void rotateOne(int[] A)
    {
        int len = A.length;
        int temp = A[len-1];
        for(int i=len-1; i>0; i--)
        {
            A[i] = A[i-1];
        }
        A[0] = temp;
    }
}
