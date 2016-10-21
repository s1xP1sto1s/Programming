/*
1015. Reversible Primes (20)
A reversible prime in any number system is a prime whose "reverse" in that number system is also a prime. 
For example in the decimal system 73 is a reversible prime because its reverse 37 is also a prime.

Now given any two positive integers N (< 105) and D (1 < D <= 10), you are supposed to tell if N is a reversible prime with radix D.

Input Specification:

The input file consists of several test cases. Each case occupies a line which contains two integers N and D. 
The input is finished by a negative N.

Output Specification:

For each test case, print in one line "Yes" if N is a reversible prime with radix D, or "No" if not.

Sample Input:
73 10
23 2
23 10
-2
Sample Output:
Yes
Yes
No
*/
/*
题目的意思是：给两个整数N和D，D是基数，N是十进制的数。
先判断N是不是素数，若是，将N转换成D进制的数(除以D取余数)，再取反，在转换成十进制数判断是否为素数。
注意！！0和1不是素数
*/
import java.util.*;
class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    while(num>=0)
    {
      int radix = sc.nextInt();
      if(isPrime(num))
      {
        int numRe = reverse(num,radix);
        if(isPrime(numRe))
          System.out.println("Yes");
        else
          System.out.println("No");
      }
      else
        System.out.println("No");
      sc.nextLine();
      num = sc.nextInt();
    }
  }
  public static boolean isPrime(int decimal)
  {
    if(decimal==0 || decimal==1)
      return false;
    int num = decimal-1;
    while(num>1)
    {
      if(decimal%num==0)
        return false;
      num--;
    }
    return true;
  }
  public static int reverse(int decimal,int radix)
  {
    StringBuilder sb = new StringBuilder();
    while(decimal!=0)
    {
      sb.append(decimal%radix);
      decimal = decimal/radix;
    }
    int reDecimal = 0;
    for(int i=0;i<sb.length();i++)
      reDecimal += Integer.parseInt(String.valueOf(sb.charAt(sb.length()-1-i))) * (int)Math.pow(radix,i);
    return reDecimal;
  }
}
