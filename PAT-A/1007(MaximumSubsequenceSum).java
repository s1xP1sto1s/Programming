/*
1007. Maximum Subsequence Sum (25)
Given a sequence of K integers { N1, N2, ..., NK }. A continuous subsequence is defined to be { Ni, Ni+1, ..., Nj } 
where 1 <= i <= j <= K. The Maximum Subsequence is the continuous subsequence which has the largest sum of its elements. 
For example, given sequence { -2, 11, -4, 13, -5, -2 }, its maximum subsequence is { 11, -4, 13 } with the largest sum being 20.

Now you are supposed to find the largest sum, together with the first and the last numbers of the maximum subsequence.

Input Specification:

Each input file contains one test case. Each case occupies two lines. The first line contains a positive integer K (<= 10000). 
The second line contains K numbers, separated by a space.

Output Specification:

For each test case, output in one line the largest sum, together with the first and the last numbers of the maximum subsequence. 
The numbers must be separated by one space, but there must be no extra space at the end of a line. 
In case that the maximum subsequence is not unique, output the one with the smallest indices i and j (as shown by the sample case). 
If all the K numbers are negative, then its maximum sum is defined to be 0, and you are supposed to output the first 
and the last numbers of the whole sequence.

Sample Input:
10
-10 1 2 3 4 -5 -23 3 7 -21
Sample Output:
10 1 4
*/
import java.util.*;

public class Main {
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] arr = new int[num];
    for(int i=0;i<num;i++)
      arr[i] = sc.nextInt();
    int[] res = findMaxSub(arr,0,num-1);
    StringBuilder sb = new StringBuilder();
    if(res[0]<0)
    {
      sb.append(0);
      sb.append(" "+arr[0]);
      sb.append(" "+arr[num-1]);
    }
    else
    {
      sb.append(res[0]);
      sb.append(" "+arr[res[1]]);
      sb.append(" "+arr[res[2]]);
    }
    System.out.println(sb.toString().trim());
  }
  public static int[] crossMaxSum(int[] arr,int low,int mid,int high)
  {
    int leftMax = Integer.MIN_VALUE;
    int rightMax = Integer.MIN_VALUE;
    int left = -1;
    int right = -1;
    
    int sum = 0;
    for(int i=mid;i>=low;i--)
    {
      sum += arr[i];
      if(sum>leftMax)
      {
        leftMax = sum;
        left = i;
      }
      else if(sum==leftMax && i<left)
        left = i;
    }
    sum = 0;
    for(int i=mid+1;i<=high;i++)
    {
      sum += arr[i];
      if(sum>rightMax)
      {
        rightMax = sum;
        right = i;
      }
      else if(sum==rightMax && i<right)
        right = i;
    }
    return new int[]{leftMax+rightMax,left,right};
  }
  
  public static int[] findMaxSub(int[] arr,int low,int high)
  {
    if(low==high)
      return new int[]{arr[low],low,high};
    int mid = (low+high)/2;
    int[] left = findMaxSub(arr,low,mid);
    int[] right = findMaxSub(arr,mid+1,high);
    int[] cross = crossMaxSum(arr,low,mid,high);
    
    if(left[0]>right[0] && left[0]>cross[0])
      return left;
    else if(right[0]>left[0] && right[0]>cross[0])
      return right;
    else if(cross[0]>left[0] && cross[0]>right[0])
      return cross;
    else if(left[0]==right[0] || left[0]==cross[0])
      return left;
    else
      return cross;
  }
}
