/*
Shortest Source to Destination Path

Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) 
and if there is one path, print the minimum no of steps needed to reach it, else print -1 
if the destination is not reachable. You may move in only four direction ie up, down, left 
and right. The path can only be created out of a cell if its value is 1.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases 
follow. Each test case contains two lines . The first line of each test case contains two integers 
n and m denoting the size of the matrix. Then in the next line are n*m space separated values of the 
matrix. The following line after it contains two integers x and y denoting the index of the destination.

Output:
For each test case print in a new line the min no of steps needed to reach the destination.

Constraints:
1<=T<=100
1<=n,m<=20

Example:
Input:
2
3 4
1 0 0 0 1 1 0 1 0 1 1 1
2 3
3 4
1 1 1 1 0 0 0 1 0 0 0 1
0 3
Output:
5
3  */


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static boolean issafe(int[][] a,int i,int j,int r,int c,boolean[][] vis){
        if(i<0 || i>=r || j<0 || j>=c || a[i][j]==0 || vis[i][j])
            return false;
        return true;
    }
    public static void dfs(int[][] a,int i,int j,int r,int c,int[] ans,int n,int di,int dj,boolean[][] vis,int in){
        if(i==di && j==dj){
            ans[in] = n;
            in = in+1;
            return;
        }
        if(!issafe(a,i,j,r,c,vis)){
            n--;
            return;
        }
        n++;
        vis[i][j] = true;
        dfs(a,i-1,j,r,c,ans,n,di,dj,vis,in);
        dfs(a,i+1,j,r,c,ans,n,di,dj,vis,in);
        dfs(a,i,j-1,r,c,ans,n,di,dj,vis,in);
        dfs(a,i,j+1,r,c,ans,n,di,dj,vis,in);
    }
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] s1 = br.readLine().split("\\s");
		    int r = Integer.parseInt(s1[0]);
		    int c = Integer.parseInt(s1[1]);
		    String[] s = br.readLine().split("\\s");
		    int[][] a = new int[r][c];
		    int k=0,i,j;
		    for(i=0;i<r;i++){
		        for(j=0;j<c;j++){
		            a[i][j] = Integer.parseInt(s[k]);k++;
		        }
		    }
		    String[] s2 = br.readLine().split("\\s");
		    int ri = Integer.parseInt(s2[0]);
		    int cj = Integer.parseInt(s2[1]);
		    

		    if(a[ri][cj]==0)
		        System.out.println("-1");
		    else{
		    int[] ans = new int[100];
		    for(i=0;i<ans.length;i++)
		        ans[i] = Integer.MAX_VALUE;
		    boolean[][] vis = new boolean[r][c];
		    dfs(a,0,0,r,c,ans,0,ri,cj,vis,0);
		    int min=Integer.MAX_VALUE;

		    for(i=0;i<ans.length;i++)
		        min = Math.min(min,ans[i]);
		    if(min == Integer.MAX_VALUE)
		        System.out.println("-1");
		    else
		        System.out.println(min);
		    }
		}
	}
}