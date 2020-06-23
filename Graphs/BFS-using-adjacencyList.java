/*
Input:
4
6
0 1
0 2
1 2
2 0
2 3
3 3

Output:

Adjacency list of vertex0
 -> 1 -> 2 -> 2
BFS traversal of the graph is:

Adjacency list of vertex1
 -> 0 -> 2
BFS traversal of the graph is:

Adjacency list of vertex2
 -> 0 -> 1 -> 0 -> 3
BFS traversal of the graph is:

Adjacency list of vertex3
 -> 2 -> 3 -> 3
BFS traversal of the graph is:
2 0 1 3 

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
             System.out.println("BFS traversal of the graph is:");
            
        } 
        bfs(adj,2,vertex);
     }
     public static void bfs(ArrayList<ArrayList<Integer>> adj,int s,int vertex)
     {
         int visited[]=new int[vertex+1];
         Arrays.fill(visited,0);
        
         visited[s]=1;
         Queue<Integer> q=new LinkedList<>();
         q.add(s);
         while(!q.isEmpty())
         {
             int u=q.poll();
             System.out.print(u+" ");
             for(int v:adj.get(u))
             {
                 if(visited[v]==0)
                 {
                     visited[v]=1;
                     q.add(v);
                 }
             }
         }
     }
}