/*
Detect cycle in an undirected graph 
Given a Undirected Graph. Check whether it contains a cycle or not. 

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' testcases follow. 
Each testcase consists of two lines. Description of testcases are as follows: The First line of each testcase 
contains two integers 'N' and 'M' which denotes the no of vertices and no of edges respectively. The Second line 
of each test case contains 'M'  space separated pairs u and v denoting that there is a bidirectional  edge from u to v .

Output:
The method should return 1 if there is a cycle else it should return 0.

User task:
You don't need to read input or print anything. Your task is to complete the function isCyclic which takes the Graph and 
the number of vertices as inputs and returns true if the given undirected graph contains any cycle. Else, it returns false.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

User function Template for Java

ArrayList<ArrayList<Integer>> list: represent graph containing 'V' number of vertices and edges between them
V: represent number of vertices
*/


class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
       // add your code here
       boolean visited[] = new boolean[V];
       for(int i=0;i<V;i++){
           if(visited[i]==false)
                if(dfs(list,i,visited,-1)==true)
                    return true;
       }
       return false;
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> list, int s, boolean visited[], int parent)
    {
        visited[s] = true;
        Iterator<Integer> i = list.get(s).listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]){
                if (dfs(list,n,visited,s))
                    return true;
            }
            else if(n != parent)
                return true;
        }
        return false;
    }
}