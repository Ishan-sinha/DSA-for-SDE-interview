/*
The idea is to maintain two sets of vertices. The first set contains the vertices already included in the MST,
the other set contains the vertices not yet included. At every step, it considers all the edges that connect 
the two sets, and picks the minimum weight edge from these edges. After picking the edge, it moves the other
endpoint of the edge to the set containing MST.
*/
class MST {
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
       
        int max=Integer.MAX_VALUE;
        ArrayList<Integer> wt = new ArrayList<Integer>(V);
        
        for(int i=0;i<V;i++){ // Weight values used to pick minimum weight edge in
//Initialized with max as of now
            wt.add(new Integer(max));
        }
        
        ArrayList<Integer> parent = new ArrayList<Integer>(V);
        for(int i=0;i<V;i++){// ArrayList to store constructed MST 
            parent.add(-1);
        }
        ArrayList<Boolean> visited = new ArrayList<Boolean>(V);
        for(int i=0;i<V;i++)//List to check which vertices are already visited
         visited.add(false);
        parent.set(0,0);
        wt.set(0,0);

            // Update weight value and parent index of the adjacent 
            // vertices of the picked vertex. Consider only those 
            // vertices which are not yet included in MST 
        for(int i=0;i<V-1;i++){
            int minVertex=getMin(wt,visited);
            
            visited.set(minVertex,true);
            
            
            for(int j=0;j<V;j++){
// graph[i][j] is non zero only for adjacent vertices of m 
                // mstSet[i] is false for vertices not yet included in MST 
                // Update the key only if graph[i][j] is smaller than key[j] 
                if((!visited.get(j))&&graph.get(minVertex).get(j)!=max){
                    if(graph.get(minVertex).get(j)<wt.get(j)){
                        wt.set(j,graph.get(minVertex).get(j));
                        parent.set(j,minVertex);
                    }
                }
            }
        }
        int sum=0;
      for(int i=0;i<V;i++){//total sum of weights in MST
          sum+=wt.get(i);
      }
     
       return sum;
    }
// A function to find the vertex with minimum key 
    // value, from the set of vertices not yet included in MST
    static int getMin(ArrayList<Integer> wt,ArrayList<Boolean> vis){
        int Min=-1;
        for(int i=0;i<wt.size();i++){
            if((!vis.get(i))&&(Min == -1 || wt.get(i)<wt.get(Min)))
             Min=i;
            }
        return Min;
    }
}