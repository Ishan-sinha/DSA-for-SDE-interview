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
        } 
     }
}