/*

Strongly Connected Components (Kosaraju's Algo)

Given a graph with N nodes and M directed edges. Your task is to complete the function kosaraju() 
which returns an integer denoting the number of strongly connected components in the graph.

Input:
The first line of input contains an integer T. Then T test cases follow. Each test case contains two 
integers N and M. In the next line there are M space-separated values u,v denoting an edge from u to v.

Output:
For each test case in a new line output will an integer denoting the no of strongly connected components present in the graph.

Your Task:
You don't need to read input or print anything. Your task is to complete the function kosaraju() which 
takes the number of vertices V and adjacency list of the graph as inputs and returns an integer denoting 
the number of strongly connected components in the given graph.

Expected Time Complexity: O(N + M).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N <= 5000
0 <= M <= (N*(N-1))
0 <= u, v <= N-1
Sum of M over all testcases will not exceed 25*106

Example:
Input:
2
5 5
1 0 0 2 2 1 0 3 3 4
3 3
0 1 1 2 2 0

Output:
3
1   */


import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            
            int vertices = Integer.parseInt(sc.next());
            int edges = Integer.parseInt(sc.next());
            
            for(int i =0; i < vertices; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edges; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 list.get(u).add(v);
            }
            
            Solution T = new Solution();
            System.out.println(T.kosaraju(list, vertices));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

// adj : Adjacency list representing the graph
// N: No of vertices


class Solution
{
    static Stack<Integer> stack;
    static void dfs(ArrayList<ArrayList<Integer>> list, boolean visited[], int start, Stack<Integer> stack)
    {
        visited[start]=true;
        ArrayList<Integer> temp = list.get(start);
        for(int i=0; i<temp.size(); i++)
        {
            int num=temp.get(i);
            if(visited[num]==false)
            {
                dfs(list,visited,num,stack);
            }
        }
        stack.push(start);
    }
    
    static void reverse(ArrayList<ArrayList<Integer>> revlist, ArrayList<ArrayList<Integer>> list)
    {
        for(int i=0; i<list.size(); i++)
        {
            for(int j=0; j<list.get(i).size(); j++)
            {
                int num = list.get(i).get(j);
                revlist.get(num).add(i);
            }
        }
    }
    
    static void print(ArrayList<ArrayList<Integer>> list )
    {
        for(int i=0 ;i<list.size(); i++)
        {
            System.out.print(i+"-> ");
            for(int j=0; j<list.get(i).size() ;j++)
            {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    static void dfs2(ArrayList<ArrayList<Integer>> list, boolean visited[], int start)
    {
        visited[start]=true;
        ArrayList<Integer> temp = list.get(start);
        for(int i=0; i<temp.size(); i++)
        {
            int num=temp.get(i);
            if(visited[num]==false)
            {
                dfs2(list,visited,num);
            }
        }
    }
    
    public int kosaraju(ArrayList<ArrayList<Integer>> list, int n)
    {
      stack = new Stack<Integer>();
      boolean visited[]= new boolean[n];
      for(int i=0; i<n; i++)
      {
          if(visited[i]==false)
          {
              dfs(list,visited,i,stack);
          }
      }
      
     ArrayList<ArrayList<Integer>> revlist = new ArrayList<ArrayList<Integer>>();
     
     for(int i=0; i<n; i++)
     {
         revlist.add(new ArrayList<Integer>());
     }
     reverse(revlist, list);
     
     Arrays.fill(visited,false);
     int cnt=0;
     while(!stack.isEmpty())
     {
         int start= stack.pop();
         if(visited[start]==false)
         {
             cnt++;
             dfs2(revlist, visited, start);
         }
     }
     return cnt;
    }
}

