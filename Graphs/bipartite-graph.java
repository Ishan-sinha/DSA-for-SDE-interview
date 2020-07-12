/*

Bipartite Graph

Given an adjacency matrix representation of a graph g having 0 based index your task is to complete the function isBipartite which returns true if the graph is a bipartite graph else returns false.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains an integer v denoting the no of vertices of the graph then in the next line are v*v space separated values of the adjacency matrix representation of the graph g.

Output:
For each test case in a new line output will be 1 if the graph is bipartite else 0.

Constraints:
1<=T<=100
1<=v<=15
0<=g[][]<=1

Example(To be used only for expected output):
Input:
2
4
0 1 0 1 1 0 1 0 0 1 0 1 1 0 1 0
3
0 1 0 0 0 1 1 0 0
Output:
1
0

*/

// Java program to find out whether a given graph is Bipartite or not
import java.util.*;
import java.lang.*;
import java.io.*;

class Bipartite
{ 
	public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
        int V = sc.nextInt();
		int[][] G = new int[V][V];
		for(int i = 0; i < V; i++)
			for(int j = 0; j < V; j++)
				G[i][j] = sc.nextInt();
		GfG b = new GfG();
        if (b.isBipartite(G, V))
           System.out.println("1");
        else
           System.out.println("0");
		}
    }
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	  boolean isBipartite(int G[][],int V)
       {
          //add code here.
        // Create a color array to store colors assigned  
        // to all veritces. Vertex/ number is used as  
        // index in this array. The value '-1' of   
        // colorArr[i] is used to indicate that no color  
        // is assigned to vertex 'i'. The value 1 is used  
        // to indicate first color is assigned and value 
        // 0 indicates second color is assigned. 
        int colorArr[] = new int[V]; 
        for (int i = 0; i < V; ++i) 
            colorArr[i] = -1; 
       
        // This code is to handle disconnected graoh 
        for (int i = 0; i < V; i++) 
          if (colorArr[i] == -1) 
            if (isBipartiteUtil(G, i, colorArr,V) == false) 
               return false; 
       
         return true;
        }
    public static boolean isBipartiteUtil(int G[][], int src, int colorArr[], int V) 
    { 
        colorArr[src] = 1; 
       
        // Create a queue (FIFO) of vertex numbers and  
        // enqueue source vertex for BFS traversal 
        LinkedList<Integer> q = new LinkedList<Integer>(); 
        q.add(src); 
       
        // Run while there are vertices in queue  
        // (Similar to BFS) 
        while (!q.isEmpty()) 
        { 
            // Dequeue a vertex from queue  
            // ( Refer http://goo.gl/35oz8 ) 
            int u = q.getFirst(); 
            q.pop(); 
       
            // Return false if there is a self-loop  
            if (G[u][u] == 1) 
               return false;   
       
             // Find all non-colored adjacent vertices 
            for (int v = 0; v < V; ++v) 
            { 
                // An edge from u to v exists and 
                // destination v is not colored 
                if (G[u][v] ==1 && colorArr[v] == -1) 
                { 
                    // Assign alternate color to this 
                    // adjacent v of u 
                    colorArr[v] = 1 - colorArr[u]; 
                    q.push(v); 
                } 
       
                // An edge from u to v exists and  
                // destination v is colored with same 
                // color as u 
                else if (G[u][v] ==1 && colorArr[v] == colorArr[u]) 
                    return false; 
            } 
        } 
       
        // If we reach here, then all adjacent vertices 
        // can be colored with alternate color 
        return true; 
    }
}