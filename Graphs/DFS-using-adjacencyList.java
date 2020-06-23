/*
Input:
5
7 
0 1 
0 2 
0 3
1 2 
2 4
3 3 
4 4

Output:

Adjacency list of vertex0
 -> 1 -> 2 -> 3
DFS traversal of the graph is:

Adjacency list of vertex1
 -> 0 -> 2
DFS traversal of the graph is:

Adjacency list of vertex2
 -> 0 -> 1 -> 4
DFS traversal of the graph is:

Adjacency list of vertex3
 -> 0 -> 3 -> 3
DFS traversal of the graph is:

Adjacency list of vertex4
 -> 2 -> 4 -> 4
DFS traversal of the graph is:
0 1 2 4 3 

*/
import java.util.*;
public class HelloWorld{
    static void addedge(ArrayList<ArrayList<Integer>> adj,int u,int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

     public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int vertex=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<vertex;i++)
        adj.add(new ArrayList<Integer>());
        int edge=sc.nextInt();
        for(int i=0;i<edge;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            addedge(adj,u,v);
        }
        for (int i = 0; i < adj.size(); i++) { 
            System.out.println("\nAdjacency list of vertex" + i); 
            for (int j = 0; j < adj.get(i).size(); j++) { 
                System.out.print(" -> "+adj.get(i).get(j)); 
            } 
            System.out.println();
             System.out.println("DFS traversal of the graph is:");
            
        } 
        
         int visited[]=new int[vertex+1];
         Arrays.fill(visited,0);
        
        dfs(adj,0,visited);
     }
     public static void dfs(ArrayList<ArrayList<Integer>> adj,int s,int visited[])
     {
        
         visited[s]=1;
         System.out.print(s+" ");
       
             for(int v:adj.get(s))
             {
                 if(visited[v]==0)
                 {
                     dfs(adj,v,visited);
                 }
             }
         
     }
}