/*
1005. Spell It Right (20)
Given a non-negative integer N, your task is to compute the sum of all the digits of N, and output every digit of 
the sum in English.

Input Specification:

Each input file contains one test case. Each case occupies one line which contains an N (<= 10^100).

Output Specification:

For each test case, output in one line the digits of the sum in English words. There must be one space between 
two consecutive words,but no extra space at the end of a line.

Sample Input:
12345
Sample Output:
one five
*/
/*
注意N的范围，所以用字符串接收较好，即nextLine()方法；
注意字符串的比较，比内容用equals()方法；

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();//输入0
		
		System.out.println(str.equals("0"));//true
		System.out.println(str=="0");//false
    
说明nextLine()接收的和“0”是两个字符串对象，引用不相同
*/
import java.util.*;   
class Main
{
  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    String in = s.nextLine();
    if("0".equals(in))
    {
      System.out.print("zero");
      return;
    }
    char[] ch = in.toCharArray();
    int sum = 0;
    for(char c:ch)
      sum += c - '0';
    
    Stack<Integer> st = new Stack<Integer>();
    while(sum!=0)
    {
      st.push(sum%10);
      sum = sum/10;
    }
    String[] str = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
    System.out.print(str[st.pop()]);
    while(!st.empty())
    {
      System.out.print(" "+str[st.pop()]);
    }
  }
}
