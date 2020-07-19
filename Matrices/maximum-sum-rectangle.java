/*

Maximum sum Rectangle 

Given a 2D array, find the maximum sum subarray in it. For example, in the following 2D array, 
the maximum sum subarray is highlighted with blue rectangle and sum of this subarray is 29.

                                                          

Input:
First line of every test case consists of T test case. First line of every test case consists of 
2 integers R and C , denoting number of rows and columns. Second line consists of R*C spaced 
integers denoting number of elements in array.

Output:
Single line output, print the Max sum forming a rectangle in a 2-D matrix

Example:
Input:
1
4 5
1 2 -1 -4 -20 -8 -3 4 2 1 3 8 10 1 3 -4 -1 1 7 -6
Ouptut:
29   */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int mat[][] = new int[n][m];
		    int ans = Integer.MIN_VALUE;
		    for(int i=0;i<n;i++)
		        for(int j=0;j<m;j++)
		            mat[i][j] = sc.nextInt();
		    int arr[] = new int[n];
		    for(int l=0;l<m;l++)
            {
            Arrays.fill(arr,0);
            for(int r=l;r<m;r++)
            {
                for(int i=0;i<n;i++)
                arr[i]+=mat[i][r];
                ans=Math.max(ans,kadane(arr,n));
            }
            }
            System.out.println(ans);
		}
	}
	static int kadane(int arr[],int n)
    {
    int max_ending_here=0;
    int max_so_far=0;
    int i,j,k,count=0,min=Integer.MAX_VALUE;
    for(i=0;i<n;i++)
    {   if(arr[i]<0)
            count++;
            
        if(arr[i]<min)
            min=arr[i];
            
        max_ending_here+=arr[i];
        
        if(max_ending_here<0)
            max_ending_here=0;
            
        if(max_so_far<max_ending_here)
            max_so_far=max_ending_here;
    }
    if(count==n)
        return min;
    else
        return max_so_far;
    }
}