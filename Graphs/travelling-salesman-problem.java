/*

Travelling Salesman Problem

Given a matrix M of size N where M[i][j] denotes the cost of moving from city i to city j. 
Your task is to complete a tour from the city 0 (0 based index) to all other cities such 
that you visit each city atmost once and then at the end come back to city 0 in min cost.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test 
cases follow. Each test case contains an integer N denoting the size of the matrix then 
in the next line are N*N space separated values of the matrix M.
 
Output:
For each test case print the required result denoting the min cost of the tour in a new line.

Constraints:
1<=T<=15
1<=N<=12
1<=M[][]<=10000

Example:
Input:
2
2
0 111
112 0
3
0 1000 5000
5000 0 1000
1000 5000 0
Output:
223
3000

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static int n;

    public static void main (String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    n = sc.nextInt();
		    int[][] cities = new int[n][n];
		    boolean[] visited = new boolean[n];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            cities[i][j] = sc.nextInt();
		        }
		    }
		    Arrays.fill(visited, false);
		    System.out.println(travellingSalesMan(cities, visited, 0));
		}
	}

    public static int travellingSalesMan(int cities[][], boolean visited[], int city){
        visited[city] = true;
        int cost, minCost = Integer.MAX_VALUE;
        for(int adj=0; adj<n; adj++){
            if(city != adj && !visited[adj]){
                cost = cities[city][adj] + travellingSalesMan(cities, visited, adj);
                minCost = Math.min(cost, minCost);
            }
        }
        
        visited[city] = false;
        
        if(minCost == Integer.MAX_VALUE){
            return cities[city][0];
        }else{
            return minCost;
        }
        
    }
    
}