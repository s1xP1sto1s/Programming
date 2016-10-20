1012. The Best Rank (25)
/*
To evaluate the performance of our first year CS majored students, we consider their grades of three courses only: 
C - C Programming Language, M - Mathematics (Calculus or Linear Algebra), and E - English. At the mean time,
we encourage students by emphasizing on their best ranks -- that is, among the four ranks with respect to the three courses
and the average grade, we print the best rank for each student.

For example, The grades of C, M, E and A - Average of 4 students are given as the following:

StudentID  C  M  E  A
310101     98 85 88 90
310102     70 95 88 84
310103     82 87 94 88
310104     91 91 91 91
Then the best ranks for all the students are No.1 since the 1st one has done the best in C Programming Language, 
while the 2nd one in Mathematics, the 3rd one in English, and the last one in average.

Input

Each input file contains one test case. Each case starts with a line containing 2 numbers N and M (<=2000), 
which are the total number of students, and the number of students who would check their ranks, respectively. 
Then N lines follow, each contains a student ID which is a string of 6 digits, followed by the three integer grades 
(in the range of [0, 100]) of that student in the order of C, M and E. Then there are M lines, each containing a student ID.

Output

For each of the M students, print in one line the best rank for him/her, and the symbol of the corresponding rank, separated by a space.

The priorities of the ranking methods are ordered as A > C > M > E. Hence if there are two or more ways for a student to 
obtain the same best rank, output the one with the highest priority.

If a student is not on the grading list, simply output "N/A".

Sample Input
5 6
310101 98 85 88
310102 70 95 88
310103 82 87 94
310104 91 91 91
310105 85 90 90
310101
310102
310103
310104
310105
999999
Sample Output
1 C
1 M
1 E
1 A
3 A
N/A
*/
import java.util.*;
class Main
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    String[] num = sc.nextLine().split(" ");
    int m = Integer.parseInt(num[0]);
    int n = Integer.parseInt(num[1]);
    String[] res = new String[n];
    
    Map<String,Integer> mapC = new HashMap<String,Integer>();
    Map<String,Integer> mapM = new HashMap<String,Integer>();
    Map<String,Integer> mapE = new HashMap<String,Integer>();
    Map<String,Integer> mapA = new HashMap<String,Integer>();
    List<Integer> listC = new ArrayList<Integer>();
    List<Integer> listM = new ArrayList<Integer>();
    List<Integer> listE = new ArrayList<Integer>();
    List<Integer> listA = new ArrayList<Integer>();
    Map<Integer,Integer> rankC = new HashMap<Integer,Integer>();
    Map<Integer,Integer> rankM = new HashMap<Integer,Integer>();
    Map<Integer,Integer> rankE = new HashMap<Integer,Integer>();
    Map<Integer,Integer> rankA = new HashMap<Integer,Integer>();
    
    for(int i=0;i<m;i++)
    {
      String[] line = sc.nextLine().split(" ");
      mapC.put(line[0],Integer.valueOf(line[1]));
      mapM.put(line[0],Integer.valueOf(line[2]));
      mapE.put(line[0],Integer.valueOf(line[3]));
      int avg = Math.round((Integer.valueOf(line[1])+Integer.valueOf(line[2])+Integer.valueOf(line[3]))/3);
      mapA.put(line[0],avg);
      
      listC.add(Integer.valueOf(line[1]));
      listM.add(Integer.valueOf(line[2]));
      listE.add(Integer.valueOf(line[3]));
      listA.add(avg);
    }
    Collections.sort(listC);
    Collections.sort(listM);
    Collections.sort(listE);
    Collections.sort(listA);
    rank(rankC,listC);
    rank(rankM,listM);
    rank(rankE,listE);
    rank(rankA,listA);
    for(int i=0;i<n;i++)
    {
      String line = sc.nextLine();
      if(mapC.containsKey(line))
      {
        int[] tmp = new int[4];
        tmp[0] = rankC.get(mapC.get(line));
        tmp[1] = rankM.get(mapM.get(line));
        tmp[2] = rankE.get(mapE.get(line));
        tmp[3] = rankA.get(mapA.get(line)); 
        res[i] = out(tmp);
      }
      else
        res[i] = "N/A";
    }
    for(int i=0;i<res.length;i++)
      System.out.println(res[i]);
  }
  public static void rank(Map<Integer,Integer> map,List<Integer> list)
  {
    int r = 1;
    int count = 0;
    map.put(list.get(list.size()-1),r);
    for(int i=list.size()-2;i>=0;i--)
    {
      count++;
      if(list.get(i)==list.get(i+1))
        map.put(list.get(i),r);
      else
      {
        r = count+1;
        map.put(list.get(i),r);
      }
    }
  }
  public static String out(int[] arr)
  {
    int min = 0;
    for(int i=1;i<arr.length;i++)
    { 
      if(arr[i]<arr[min])
        min = i;
    }
    if(arr[3]==arr[min])
      min = 3;
    switch(min)
    {
      case 0:
        return (arr[0]+" "+'C');
      case 1:
        return (arr[1]+" "+'M');
      case 2:
        return (arr[2]+" "+'E');
      case 3:
        return (arr[3]+" "+'A');
    }
    return "N/A";
  }
}
