/*
1009. Product of Polynomials (25)
This time, you are supposed to find A*B where A and B are two polynomials.

Input Specification:

Each input file contains one test case. Each case occupies 2 lines, and each line contains the information of a polynomial: 
K N1 aN1 N2 aN2 ... NK aNK, where K is the number of nonzero terms in the polynomial, Ni and aNi (i=1, 2, ..., K) 
are the exponents and coefficients, respectively. It is given that 1 <= K <= 10, 0 <= NK < ... < N2 < N1 <=1000.

Output Specification:

For each test case you should output the product of A and B in one line, with the same format as the input. 
Notice that there must be NO extra space at the end of each line. Please be accurate up to 1 decimal place.

Sample Input
2 1 2.4 0 3.2
2 2 1.5 1 0.5
Sample Output
3 3 3.6 2 6.0 1 1.6
*/
/*
模拟多项式乘法
注意两个可能等于0的地方：
1、多项式相乘 系数为0 continue
2、合并同类项 系数为0 remove(key)
*/
import java.util.*;
class Main
{    
 public static void main(String[] args)
    {
      Scanner sc = new Scanner(System.in);
      String[] str1 = sc.nextLine().split(" ");
      String[] str2 = sc.nextLine().split(" ");
      
      Map<Integer,Double> hm1 = new TreeMap<Integer,Double>();
      Map<Integer,Double> hm2 = new TreeMap<Integer,Double>();
      for(int i=0;i<Integer.parseInt(str1[0]);i++)
        hm1.put(Integer.valueOf(str1[2*i+1]),Double.valueOf(str1[2*(i+1)]));
      for(int i=0;i<Integer.parseInt(str2[0]);i++)
        hm2.put(Integer.valueOf(str2[2*i+1]),Double.valueOf(str2[2*(i+1)]));
      
      Map<Integer,Double> map = new TreeMap<Integer,Double>(new Comparator<Integer>(){
        public int compare(Integer a,Integer b)
        {
          return b-a;
        }
      });
      Set<Integer> set1 = hm1.keySet();
      Set<Integer> set2 = hm2.keySet();
      for(Integer key1:set1)
      {
        for(Integer key2:set2)
        {
          Double val = hm1.get(key1) * hm2.get(key2);
          Integer key = key1 + key2;
          if(val==0)
            continue;
          else
          {
            if(map.containsKey(key))
            {
              double temp = map.get(key) + val;
              if(temp==0)
                map.remove(key);
              else
                map.put(key,temp);
            }
            else
              map.put(key,val);
          }
        }
      }
      StringBuilder sb = new StringBuilder();
      sb.append(map.size());
      Set<Integer> set3 = map.keySet();
      for(Integer key3:set3)
      {
        sb.append(" "+key3);
        sb.append(" "+(double)Math.round(map.get(key3)*10)/10);
      }
      System.out.println(sb.toString());
    }
}
