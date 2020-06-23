import java.util.*;
public class HelloWorld{

     public static void main(String []args){
       Scanner sc=new Scanner(System.in);
       int vertex=sc.nextInt();
       int edges=sc.nextInt();
       int m[][]=new int[vertex+1][vertex+1];
       for(int i=1;i<=edges;i++)
       {
           int u=sc.nextInt();
           int v=sc.nextInt();
           m[u][v]=1;
           m[v][u]=1;
       }
       for(int i=0;i<=vertex;i++)
       {
           for(int j=0;j<=vertex;j++)
           System.out.print(m[i][j]+" ");
           System.out.println();
       }
       bfs(m,2,vertex);
     }
     public static void bfs(int m[][],int s,int vertex)
     {
         int visited[]=new int[vertex+1];
         Arrays.fill(visited,0);
         System.out.print(s+" ");
         visited[s]=1;
       Queue<Integer> q= new LinkedList<Integer>(); 
         q.add(s);
         while(!q.isEmpty())
         {
             int i=q.remove();
             for(int j=0;j<=vertex;j++)
             {
                 if(m[i][j]==1 && visited[j]==0)
                 {
                     System.out.print(j + " ");
                     visited[j]=1;
                     q.add(j);
                 }
             }
         }
     }
}