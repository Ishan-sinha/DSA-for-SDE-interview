/*
Given a Matrix consisting of 0s and 1s. Find the number of islands of connected 1s present in the matrix. 
Note: A 1 is said to be connected if it has another 1 around it (either of the 8 directions).

Input:
The first line of input will be the number of testcases T, then T test cases follow. The first line of each
testcase contains two space separated integers N and M. Then in the next line are the NxM inputs of the matrix A separated by space .

Output:
For each testcase in a new line, print the number of islands present.
Example(To be used only for expected output) :
Input
2
3 3
1 1 0 0 0 1 1 0 1
4 4
1 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0

Output
2
2

Explanation:
Testcase 1: The graph will look like
1 1 0
0 0 1
1 0 1
Here, two islands will be formed
First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][2]}
Second island will be formed by {A[2][0]}.
Testcase 2: The graph will look like
1 1 0 0
0 0 1 0
0 0 0 1
0 1 0 0
Here, two islands will be formed
First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][3]}
Second island will be formed by {A[3][1]}.

Algorithm:

Input the island matrix.
Traverse the entire matrix.
Whenever you find 1 use DFS to find all the connected ones in the 8 direction.
Change them to 0 to indicate that this element is traversed and increase the island count by 1.
Return count.
*/

class Islands {

    static int dfs(ArrayList<ArrayList<Integer>> adj, int i, int j){
       if(i<0 || i>=adj.size() || j<0 || j>=adj.get(i).size() || adj.get(i).get(j)==0){
           return 0;
       }
       
       adj.get(i).set(j,0); //substituting all possible connected 1's with 0's in ArrayList
    
        dfs(adj,i-1,j);
        dfs(adj,i+1,j);
        dfs(adj,i,j-1);
        dfs(adj,i,j+1);
        dfs(adj,i-1,j-1);
        dfs(adj,i+1,j+1);
        dfs(adj,i-1,j+1);
        dfs(adj,i+1,j-1);
        return 1;
    }
    
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
        
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(list.get(i).get(j)==1){
                    
                    dfs(list,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}