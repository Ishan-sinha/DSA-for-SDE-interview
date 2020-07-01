/*

Next larger element 

Given an array A of size N having distinct elements, the task is to find the next greater 
element for each element of the array in order of their appearance in the array. If no such element exists, output -1 

Input:
The first line of input contains a single integer T denoting the number of test cases.Then T test cases follow. 
Each test case consists of two lines. The first line contains an integer N denoting the size of the array. The 
Second line of each test case contains N space separated positive integers denoting the values/elements in the array A.

Output:
For each test case, print in a new line, the next greater element for each array element separated by space in order.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1018
Example:
Input
2
4
1 3 2 4
4
4 3 2 1
Output
3 4 4 -1
-1 -1 -1 -1  */

import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    int n = Integer.parseInt(br.readLine());
		    long a[] = new long[n];
		    
		    String s[] = br.readLine().split(" ");
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i] = Long.parseLong(s[i]);
		    }
		   
		   findNextLargerElement(a,n);
		}
	}

	    static void findNextLargerElement(long a[] , int n){
	        Stack<Long> st = new Stack<Long>();
	        HashMap<Long,Long> map = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                while(!st.isEmpty()&& a[i] > st.peek()) 
                    map.put(st.pop() , a[i]) ;
                st.push(a[i]);
            }
	        for(int i=0;i<n;i++)
	        {
	            System.out.print(map.getOrDefault(a[i],(long)-1)+" "); 
	        }
	        System.out.println();
        }
}
