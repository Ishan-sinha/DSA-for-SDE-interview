/*

Trapping Rain Water Problem

Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the 
width of each block is 1. Compute how much water can be trapped in between blocks after raining.
Structure is like below:
|  |
|_|
We can trap 2 units of water in the middle gap.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test 
cases follows. Each test case contains an integer N denoting the size of the array, followed by N space 
separated numbers to be stored in array.

Output:
Output the total unit of water trapped in between the blocks.

Constraints:
1 <= T <= 100
3 <= N <= 107
0 <= Ai <= 108

Example:
Input:
2
4
7 4 0 9
3
6 9 9

Output:
10
0          */



import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    String line[] = br.readLine().split("\\s+");
		    for(int i=0;i<n;i++)
		        arr[i] = Integer.parseInt(line[i]);
		    
		    int mxl[] = new int[n];
		    int mxr[] = new int[n];
		    int water[] = new int[n];
		    int sum = 0;
		    mxl[0] = arr[0];
		    mxr[n-1] = arr[n-1];
		    
		    for(int i=1;i<n;i++)
		        mxl[i] = max(mxl[i-1],arr[i]);
		        
		    for(int i=n-2;i>=0;i--)
		        mxr[i] = max(mxr[i+1],arr[i]);
		        
		    for(int i=0;i<n;i++){
		        water[i] = min(mxl[i],mxr[i]) - arr[i];
		        sum += water[i];
		    }
		    System.out.println(sum);
		}
	}
	static int max(int a,int b){return a>b?a:b;}
	static int min(int a,int b){return a>b?b:a;}
}