/*
Detect cycle in a directed graph 
Given a Directed Graph. Check whether it contains any cycle or not.

Input: The first line of the input contains an integer 'T' denoting the number of test cases. 
Then 'T' test cases follow. Each test case consists of two lines. Description of testcases is
as follows: The First line of each test case contains two integers 'N' and 'M'  which denotes 
the no of vertices and no of edges respectively. The Second line of each test case contains 'M'
space separated pairs u and v denoting that there is an uni-directed  edge from u to v .

Output:
The method should return 1 if there is a cycle else it should return 0.

User task:
You don't need to read input or print anything. Your task is to complete the function isCyclic which takes the Graph 
and the number of vertices and inputs and returns true if the given directed graph contains a cycle. Else, it returns false.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V). 

Complete the function below
ArrayList<ArrayList<Integer>> list: to represent graph containing 'v' vertices and edges between them
V: represent number of vertices
*/

class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
        // add your code here
        boolean visited[] = new boolean[V];
        boolean st[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(dfs(list,i,visited,st)==true)
                    return true;
            }
        }
        return false;
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> list, int s, boolean visited[], boolean st[])
    {
        visited[s] = true;
        st[s] = true;
        Iterator<Integer> i = list.get(s).listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(visited[n]==false && dfs(list,n,visited,st))
                return true;
            else if(st[n]==true)
                return true;
        }
        st[s] = false;
        return false;
    }
}