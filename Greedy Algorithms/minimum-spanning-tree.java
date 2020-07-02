/*

Minimum Spanning Tree 

Given a weighted, undirected and connected graph. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

Input:
The first line of input contains an integer T denoting the number of testcases. Then T test cases follow. The first line of each testcase contains two integers V (starting from 1), E denoting the number of nodes and number of edges. Then in the next line are 3*E space separated values a b w where a, b denotes an edge from a to b and w is the weight of the edge.

Output:
For each test case in a new line print the sum of weights of  the edges of the Minimum Spanning Tree formed of the graph.

User task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function  spanningTree() 
which takes number of vertices V and the number of edges E and a graph graph as inputs and returns an integer denoting the sum 
of weights of the edges of the Minimum Spanning Tree.
Note: Please note that input of graph is 1-based but the adjacency matrix is 0-based.

Expected Time Complexity: O(V2).
Expected Auxiliary Space: O(V).  */


import java.util.*;
import java.io.*;
import java.lang.*;

  public class Driver_class {

    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < V; j++) temp.add(Integer.MAX_VALUE);
                graph.add(temp);
            }
            str = read.readLine().trim().split(" ");
            int k = 0;
            int i=0;
            while (i++<E) {
                int u = Integer.parseInt(str[k++]);
                int v = Integer.parseInt(str[k++]);
                int w = Integer.parseInt(str[k++]);
                u--;
                v--;
                graph.get(u).set(v, w);
                graph.get(v).set(u, w);
            }

            System.out.println(new MST().spanningTree(V, E, graph));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class MST {
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
        // Add your code here
        int max=Integer.MAX_VALUE;
        ArrayList<Integer> wt = new ArrayList<Integer>(V);
        
        for(int i=0;i<V;i++){
            wt.add(new Integer(max));
        }
        
        ArrayList<Integer> parent = new ArrayList<Integer>(V);
        for(int i=0;i<V;i++){
            parent.add(-1);
        }
        ArrayList<Boolean> visited = new ArrayList<Boolean>(V);
        for(int i=0;i<V;i++)
         visited.add(false);
        parent.set(0,0);
        wt.set(0,0);
        for(int i=0;i<V-1;i++){
            int minVertex=getMin(wt,visited);
            
            visited.set(minVertex,true);
            
            
            for(int j=0;j<V;j++){
                if((!visited.get(j)) && graph.get(minVertex).get(j)!=max){
                    if(graph.get(minVertex).get(j)<wt.get(j)){
                        wt.set(j,graph.get(minVertex).get(j));
                        parent.set(j,minVertex);
                    }
                }
            }
        }
        int sum=0;
      for(int i=0;i<V;i++){
          sum+=wt.get(i);
      }
     
       return sum;
    }
    static int getMin(ArrayList<Integer> wt,ArrayList<Boolean> vis){
        int Min=-1;
        for(int i=0;i<wt.size();i++){
            if((!vis.get(i))&&(Min == -1 || wt.get(i)<wt.get(Min)))
             Min=i;
            }
        return Min;
    }
}
