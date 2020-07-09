/*

Kth smallest element 

Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

Output:
Corresponding to each test case, print the kth smallest element in a new line.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1). */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int min1 = Integer.MAX_VALUE;
		    int max = Integer.MIN_VALUE;
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    int k = sc.nextInt();
		   Arrays.sort(arr);
		    System.out.println(arr[k-1]);
		}
	}
}