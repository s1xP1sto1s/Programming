1010. Radix (25)
/*
Given a pair of positive integers, for example, 6 and 110, can this equation 6 = 110 be true? The answer is "yes", 
if 6 is a decimal number and 110 is a binary number.

Now for any pair of positive integers N1 and N2, your task is to find the radix of one number while that of the other is given.

Input Specification:

Each input file contains one test case. Each case occupies a line which contains 4 positive integers:
N1 N2 tag radix
Here N1 and N2 each has no more than 10 digits. A digit is less than its radix and is chosen from the set {0-9, a-z} 
where 0-9 represent the decimal numbers 0-9, and a-z represent the decimal numbers 10-35. The last number "radix" is 
the radix of N1 if "tag" is 1, or of N2 if "tag" is 2.

Output Specification:

For each test case, print in one line the radix of the other number so that the equation N1 = N2 is true. 
If the equation is impossible, print "Impossible". If the solution is not unique, output the smallest possible radix.

Sample Input 1:
6 110 1 10
Sample Output 1:
2
Sample Input 2:
1 ab 1 2
Sample Output 2:
Impossible
*/
/*
1、首先需要一个函数toInt(String str1，long radix)能够将指定基数radix的str转换成十进制数返回。
2、其次需要一个函数find(String str2，long num)对str2是否能够找到一个基数使得==num，能则返回，不能则返回-1
注意：基数并不局限于0-9 a-z，可以依次查找，可能会超时！所以使用二分查找。二分查找的上界为(num>start)?num+1:start+1！！
*/
import java.util.*;
class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String[] str = sc.nextLine().split(" ");
    if(str[0].equals(str[1]) && str[1].length()==1)
    {
      System.out.println(2);
      return;
    }
    if(str[0].equals(str[1]))
    {
      System.out.println(str[3]);
      return;
    }
    long num = 0L;
 
    if("1".equals(str[2]))
    {
      num = toInt(str[0],Long.parseLong(str[3]));
      long temp = find(str[1],num);
      out(temp);
    }
    else
    {
      num = toInt(str[1],Long.parseLong(str[3]));
      long temp = find(str[0],num);
      out(temp);
    }
  }
  
  private static long toInt(String str,long radix)
  {
    char[] ch = str.toCharArray();
    int len = ch.length;
    long sum = 0L;
    for(int i=0;i<len;i++)
    {
      if(ch[i]>='0' && ch[i]<='9')
        sum += (ch[i]-'0') * Math.pow(radix,len-i-1);
      else if(ch[i]>='a' && ch[i]<='z')
        sum += (ch[i]-'a'+10) * Math.pow(radix,len-i-1);
    }
    return sum;
  }
  private static long find(String str,long num)
  {
    char[] ch = str.toCharArray();
    Arrays.sort(ch);
    int max = ch[ch.length-1];
    if(max>='0' && max<='9')
      max = max - '0';
    else 
      max = max - 'a' + 10;
    /*
    for(long i=max+1;;i++)
    {
      if(toInt(str,i)==num)
	return i;
      if(toInt(str,i)>num)
        return -1;
    }*/
    long start = max+1;
    long end = (num>start)?num+1:start+1;
    while(start<=end)
    {
      long mid = (start+end)/2;
      if(toInt(str,mid)==num)
        return mid;
      else if(toInt(str,mid)<num)
        start = mid+1;
      else
        end = mid-1;
    }
    return -1;
  }
  private static void out(long res)
  {
    if(res==-1)
       System.out.println("Impossible");
    else
      System.out.println(res);
  }
}
