1001. A+B Format (20)
/*
Calculate a + b and output the sum in standard format -- that is, the digits must be separated into groups of three by commas 
(unless there are less than four digits).

Input

Each input file contains one test case. Each case contains a pair of integers a and b where -1000000 <= a, b <= 1000000. The numbers are separated by a space.

Output

For each test case, you should output the sum of a and b in one line. The sum must be written in the standard format.

Sample Input
-1000000 9
Sample Output
-999,991
*/
import java.util.*;
 
class Main
{
    public static void main(String[] args)
    {
      Scanner s = new Scanner(System.in);
      int a = s.nextInt();
      int b = s.nextInt();
      int sum = a + b;
      boolean flag = false;
      if(sum<0)
        flag = true;
      if(sum==0)
      {
        System.out.println(0);
        return;
      }
            
      StringBuilder sb = new StringBuilder();
      int count = 0;
      while(sum!=0)
      {
        count++;
        sb.insert(0,Math.abs(sum%10));
        sum = sum/10;
        if(count==3 && sum!=0)
        {
          sb.insert(0,',');
          count = 0;
        }  
      }
      if(flag==true)
        sb.insert(0,'-');
      System.out.println(sb.toString());
    }
}
