/*
1002. A+B for Polynomials (25)
This time, you are supposed to find A+B where A and B are two polynomials.

Input

Each input file contains one test case. Each case occupies 2 lines, and each line contains the information of a polynomial: 
K N1 aN1 N2 aN2 ... NK aNK, where K is the number of nonzero terms in the polynomial, Ni and aNi (i=1, 2, ..., K) 
are the exponents and coefficients, respectively. It is given that 1 <= K <= 10，0 <= NK < ... < N2 < N1 <=1000.

Output

For each test case you should output the sum of A and B in one line, with the same format as the input. 
Notice that there must be NO extra space at the end of each line. Please be accurate to 1 decimal place.

Sample Input
2 1 2.4 0 3.2
2 2 1.5 1 0.5
Sample Output
3 2 1.5 1 2.9 0 3.2
*/
/*
合并多项式，该题目需要注意的地方：
1、两个多项式合并的时候，会出现相同项系数相同合并后系数为0的情况，此时需要去除该项。（一定是系数为0才能去除，0.000001也不能去除，
只是最后保留一位小数打印的时候该项系数为0.0）
2、打印结果时从大到小，TreeMap保存的是默认从小到大，所以重新定义一个比较器作为TreeMap构造器参数，采用匿名内部类的形式。
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
      Map<Integer,Double> hm2 = new TreeMap<Integer,Double>(new Comparator<Integer>(){
        public int compare(Integer a,Integer b)
          {
            return b-a;
          }
      });
      for(int i=0;i<Integer.parseInt(str1[0]);i++)
        hm1.put(Integer.valueOf(str1[2*i+1]),Double.valueOf(str1[2*(i+1)]));
      for(int i=0;i<Integer.parseInt(str2[0]);i++)
        hm2.put(Integer.valueOf(str2[2*i+1]),Double.valueOf(str2[2*(i+1)]));
      
      Set<Integer> set = hm1.keySet();
      Iterator<Integer> it = set.iterator();
      while(it.hasNext())
      {
        Integer key = it.next();
        if(hm2.containsKey(key))
        {
          //double val = (double)Math.round((hm1.get(key)+hm2.get(key))*10)/10;
          double val = hm1.get(key)+hm2.get(key);
          if(val==0.0)
            hm2.remove(key);
          else
            hm2.put(key,val);
        }
        else
          hm2.put(key,hm1.get(key));
      }
      
      StringBuilder sb = new StringBuilder();
      Set<Map.Entry<Integer,Double>> sm = hm2.entrySet();
      sb.append(sm.size());
      Iterator<Map.Entry<Integer,Double>> itm = sm.iterator();
      while(itm.hasNext())
      {
        Map.Entry<Integer,Double> me = itm.next();
        sb.append(" "+me.getKey());
       // sb.append(" "+me.getValue());
        sb.append(" "+(double)Math.round(me.getValue()*10)/10);
      }
      
      System.out.println(sb.toString());
    } 
}
