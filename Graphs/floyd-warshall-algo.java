/*

Floyd Warshall

The problem is to find shortest distances between every pair of vertices in a given edge weighted 
directed Graph. The Graph is represented as Adjancency Matrix, and the Matrix denotes the weight of 
the edegs (if it exists) else INF (1e7).

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. 
The first line of each test case contains an integer V denoting the size of the adjacency matrix. The 
next V lines contain V space separated values of the matrix (graph). All input will be integer type.

Output:
For each test case output will be V*V space separated integers where the i-jth integer 
denote the shortest distance of ith vertex from jth vertex. For INT_MAX integers output INF.

Constraints:
1 <= T <= 20 
1 <= V <= 100
1 <= graph[][] <= 500

Example:
Input
2
2
0 25
INF 0
3
0 1 43
1 0 6
INF INF 0

Output
0 25
INF 0 
0 1 7
1 0 6
INF INF 0           */

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    while(t!=0)
	    {
	        t--;
	        int V=Integer.parseInt(br.readLine());
	        int graph[][]=new int[V][V];
	        for(int i=0;i<V;i++){
	        String data[]=br.readLine().trim().split(" ");
	        
	        for(int j=0;j<V;j++)
	        {
	            graph[i][j]=Integer.parseInt(data[j]);
	        }
	        }
	        GFG obj=new GFG();
	        obj.findDist(graph,V);
	        
	    
	     }
	 }
	 
	 public void findDist(int[][] graph,int V){
	     int[][] dist=new int[V][V];
	     int INF= 10000000;
	     for(int i=0;i<V;i++)
	        for(int j=0;j<V;j++)
	            if(graph[i][j]>INF)
	                dist[i][j]=INF;
	            else
	                dist[i][j]=graph[i][j];
	    
	    for(int k=0;k<V;k++)
	        for(int i=0;i<V;i++)
	            for(int j=0;j<V;j++){
	                if(dist[i][k]==INF||dist[k][j]==INF)
	                    continue;
	                if(dist[i][j]>dist[i][k]+dist[k][j])
	                    dist[i][j]=dist[i][k]+dist[k][j];
	                
	            }
	    printDist(dist);
	 }
	 
	 public void printDist(int[][] dist){
	     int n=dist.length;
	     int INF=10000000;
	     StringBuffer br= new StringBuffer();
	     for(int i=0;i<n;i++){
	        for(int j=0;j<n;j++){
	            if(dist[i][j]==INF)
	                br.append("INF ");
	           else
	            br.append(dist[i][j]+" ");
	            
	        }
	        br.append("\n");
	         
	     }
	     System.out.println(br.toString().trim());
	 }
}