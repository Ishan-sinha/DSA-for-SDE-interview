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
3

Output:

Adjacency list of vertex0
 -> 1 -> 2 -> 2
Distance from source vertex from the other vertices are :

Adjacency list of vertex1
 -> 0 -> 2
Distance from source vertex from the other vertices are :

Adjacency list of vertex2
 -> 0 -> 1 -> 0 -> 3
Distance from source vertex from the other vertices are :

Adjacency list of vertex3
 -> 2 -> 3 -> 3
Distance from source vertex from the other vertices are :
Distance from 3 to 0 is: 2 
Distance from 3 to 1 is: 2 
Distance from 3 to 2 is: 1 
Distance from 3 to 3 is: 0 

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
             System.out.println("Distance from source vertex from the other vertices are :");
            
        } 
        int s=sc.nextInt();
        bfs(adj,s,vertex);
     }
     public static void bfs(ArrayList<ArrayList<Integer>> adj,int s,int vertex)
     {
         int visited[]=new int[vertex+1];
         Arrays.fill(visited,0);
        int dist[]=new int[vertex+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s]=0;
         visited[s]=1;
         Queue<Integer> q=new LinkedList<>();
         q.add(s);
         while(!q.isEmpty())
         {
             int u=q.poll();
         
             for(int v:adj.get(u))
             {
                 if(visited[v]==0)
                 {
                     dist[v]=dist[u]+1;
                     visited[v]=1;
                     q.add(v);
                 }
             }
         }
         for(int i=0;i<vertex;i++)
         {
         System.out.print("Distance from "+ s+" to "+i+" is: ");
         System.out.println(dist[i]+" ");
         }
     }
}