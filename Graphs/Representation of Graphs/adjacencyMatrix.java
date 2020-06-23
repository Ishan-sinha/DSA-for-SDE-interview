import java.util.*;
public class HelloWorld{

     public static void main(String []args){
       Scanner sc=new Scanner(System.in);
       int vertex=sc.nextInt();// input number of vertices
       int edges=sc.nextInt();//input number of edges
       int m[][]=new int[vertex+1][vertex+1];//Initialize the matrix
       for(int i=1;i<=edges;i++)
       {
           int u=sc.nextInt();//input the firt vertex of edge
           int v=sc.nextInt();//input second vertex
           m[u][v]=1;//undirected graph so will update the matrix for (u,v)
           m[v][u]=1;//also update the matrix for (v,u)
       }
       for(int i=1;i<vertex;i++)
       {
           for(int j=1;j<vertex;j++)
           System.out.print(m[i][j]+" ");//printing the matrix
           System.out.println();
       }
     }
}