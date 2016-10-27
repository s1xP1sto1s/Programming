/*
1003. Emergency (25)
As an emergency rescue team leader of a city, you are given a special map of your country. The map shows several scattered 
cities connected by some roads. Amount of rescue teams in each city and the length of each road between any pair of cities 
are marked on the map. When there is an emergency call to you from some other city, your job is to lead your men to the 
place as quickly as possible, and at the mean time, call up as many hands on the way as possible.

Input

Each input file contains one test case. For each test case, the first line contains 4 positive integers: 
N (<= 500) - the number of cities (and the cities are numbered from 0 to N-1), M - the number of roads, 
C1 and C2 - the cities that you are currently in and that you must save, respectively. The next line contains N integers, 
where the i-th integer is the number of rescue teams in the i-th city. Then M lines follow, 
each describes a road with three integers c1, c2 and L, which are the pair of cities connected by a road and the length of that road,
respectively. It is guaranteed that there exists at least one path from C1 to C2.

Output

For each test case, print in one line two numbers: the number of different shortest paths between C1 and C2, 
and the maximum amount of rescue teams you can possibly gather.
All the numbers in a line must be separated by exactly one space, and there is no extra space allowed at the end of a line.

Sample Input
5 6 0 2
1 2 1 5 3
0 1 1
0 2 2
0 3 1
1 2 1
2 4 1
3 4 1
Sample Output
2 4
*/
/*
Dijkstra算法求出最短路径值，DFS寻找最短路径的个数以及沿途能召集的救援队数量。
DFS的思想是：从des开始，soc到des的最短路径一定等于：存在des的某个邻接点，使得soc到这个邻接点的最短路径+邻接点与des的边长=soc到des的最短路径
soc==des时，找到一条，原路返回！！继续寻找。
*/
import java.util.*;

public class Main {
  public static int count = 0;
  public static int teamNum = 0;
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int nodeNum = sc.nextInt();
    int edgeNum = sc.nextInt();
    int soc = sc.nextInt();
    int des = sc.nextInt();
    sc.nextLine();
    
    int[] team = new int[nodeNum];
    for(int i=0;i<nodeNum;i++)
      team[i] = sc.nextInt();
    sc.nextLine();
    
    int[][] mat = new int[nodeNum][nodeNum];
    for(int i=0;i<nodeNum;i++)
    {
      for(int j=0;j<nodeNum;j++)
      {
        if(i==j)
          mat[i][j] = 0;
        else
          mat[i][j] = Integer.MAX_VALUE;
      }
    }
    for(int i=0;i<edgeNum;i++)
    {
      int row = sc.nextInt();
      int col = sc.nextInt();
      int val = sc.nextInt();
      sc.nextLine();
      mat[row][col] = val;
      mat[col][row] = val;
    }
    
    int[] dist = new int[nodeNum];
    boolean[] collected = new boolean[nodeNum];
    int[] path = new int[nodeNum];
    for(int i=0;i<nodeNum;i++)
    {
      dist[i] = Integer.MAX_VALUE;
      collected[i] = false;
      path[i] = -1;
    }
    dist[soc] = 0;
    for(int i=0;i<nodeNum;i++)
    {
      if(mat[soc][i]!=0 && mat[soc][i]<Integer.MAX_VALUE)
      {
        dist[i] = mat[soc][i];
        path[i] = soc;
      }
    }
    collected[soc] = true;
    
    dijkstra(mat,dist,collected,path);
    DFS(soc,des,mat,team,dist,team[des]);
    System.out.println(count+" "+teamNum);
    
  }
  public static void dijkstra(int[][] mat,int[] dist,boolean[] collected,int[] path)
  {
    while(true)
    {
      int min = Integer.MAX_VALUE;
      int index = dist.length + 1;
      for(int i=0;i<dist.length;i++)
      {
        if(collected[i]==false && dist[i]<min)
        {  
          min = dist[i];
          index = i;
        }
      }
      
      if(index==dist.length+1)
        break;
      
      collected[index] = true;
      for(int i=0;i<dist.length;i++)
      {
        if(mat[index][i]!=0 && mat[index][i]<Integer.MAX_VALUE && collected[i]==false)
        {
          if((dist[index]+mat[index][i])<dist[i])
          {
            dist[i] = dist[index]+mat[index][i];
            path[i] = index;
          }
        }
      }
    }
  }
  public static void DFS(int soc,int des,int[][] mat,int[] team,int[] dist,int teamSum)
  {
    if(des==soc)
    {
      count++;
      if(teamSum>teamNum)
        teamNum = teamSum;
      return;
    }
    for(int i=0;i<team.length;i++)
    {
      if(mat[des][i]!=0 && mat[des][i]<Integer.MAX_VALUE)
      {
        if(dist[i]+mat[des][i]==dist[des])
        {
        //  teamSum += team[i];
          DFS(soc,i,mat,team,dist,teamSum+team[i]);
        }
      }
    }
  }
}
