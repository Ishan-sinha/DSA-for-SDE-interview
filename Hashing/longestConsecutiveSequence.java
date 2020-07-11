/*

Given an array of positive integers. Find the length of the 
longest sub-sequence such that elements in the subsequence 
are consecutive integers, the consecutive numbers can be in
any order.

Example:
Input:
2
7
2 6 1 9 4 5 3
7
1 9 3 10 4 20 2
Output:
6
4

*/

//Initial Template for Java

import java.util.Scanner;
import java.util.*;
import java.util.HashSet;

class Driverclass
{
    // Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    
		    // Making object of GfG	
			Subseq g = new Subseq();
			
			System.out.println(g.findLongestConseqSubseq(a, n));
		
		t--;
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Subseq
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    // return the length of the longest subsequene of consecutive integers
	static int findLongestConseqSubseq(int arr[], int n)
	{
	   
	   HashSet<Integer> S = new HashSet<Integer>(); 
        int ans = 0; 
  
        
        for (int i = 0; i < n; ++i) 
            S.add(arr[i]); 
  
        
        for (int i = 0; i < n; ++i) { 
            
            if (!S.contains(arr[i] - 1)) { 
                
                int j = arr[i]; 
                while (S.contains(j)) 
                    j++; 
  
              
                if (ans < j - arr[i]) 
                    ans = j - arr[i]; 
            } 
        } 
        return ans; 
	}
}