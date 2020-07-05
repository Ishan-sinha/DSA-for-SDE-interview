/*

Maximum of all subarrays of size k

Given an array A and an integer K. Find the maximum 
for each and every contiguous subarray of size K.

Input:
The first line of input contains an integer T denoting the number of test cases. 
The first line of each test case contains a single integer N denoting the size of 
array and the size of subarray K. The second line contains N space-separated 
integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum for every subarray of size k.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ K ≤ N
0 ≤ A[i] <= 107

Example:
Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13

Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90

Explanation:
Testcase 1: Starting from first subarray of size k = 3, we have 3 as maximum. 
Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6.    */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		   String sizes[] = br.readLine().split(" ");
		   int n = Integer.parseInt(sizes[0]);
		   int k = Integer.parseInt(sizes[1]);
		   
		   String s[] = br.readLine().split(" ");
		   int a[] = new int[n];
		   for(int i =0;i<n;i++)
		    a[i] = Integer.parseInt(s[i]);
		    maxOfWindow(a,n,k);

		 }
		        
	}
	static void maxOfWindow(int a[],int n,int k)
	{   int i;
	    Deque<Integer> q = new LinkedList<>();
	    StringBuffer sb = new StringBuffer();
	    for(i=0;i<k;i++)
	    {
	        while(!q.isEmpty() && a[i]>a[q.peekLast()])
	            q.removeLast();
	       q.addLast(i);
	        
	    }
	    sb.append(a[q.peek()]+" ");
	    for(;i<n;i++)
	    {
	        while(!q.isEmpty() && q.peek() <= i-k )
	            q.removeFirst();
	            
	        while(!q.isEmpty() && a[i]>a[q.peekLast()])
	            q.removeLast();
	       q.addLast(i);
	       
	       sb.append(a[q.peek()]+" ");
	    }
	    System.out.println(sb);
	}
    
}
