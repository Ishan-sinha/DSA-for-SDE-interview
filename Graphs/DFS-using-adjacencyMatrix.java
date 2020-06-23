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
       int visited[]=new int[vertex+1];
         Arrays.fill(visited,0);
       dfs(m,2,vertex,visited);
     }
     public static void dfs(int m[][],int s,int vertex,int visited[])
     {
         
         if(visited[s]==0)
         {
         System.out.print(s+" ");
         visited[s]=1;
       
             for(int j=0;j<=vertex;j++)
             {
                 if(m[s][j]==1 && visited[j]==0)
                 dfs(m,j,vertex,visited);
             }
         }
     }
}