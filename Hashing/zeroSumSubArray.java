/*
You are given an array A of size N. 
You need to print the total count of 
sub-arrays having their sum equal to 0.
Example:
Input:
2
6
0 0 5 5 0 0
10
6 -1 -3 4 -2 2 4 6 -12 -7

Output:
6
4

*/


import java.io.*;
import java.util.*;
class main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    int arr[]=new int[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }

		    System.out.println(findSubarray(arr,n));
		}
		
	}

 // } Driver Code Ends


//User function Template for Java

public static int findSubarray(int[] arr ,int n) 
{
    //Your code here
    int s=0;
 int c=0;
    HashMap<Integer,Integer> h=new HashMap<>();
    for(int i=0;i<arr.length;i++)
    {
        s+=arr[i]; 
        if(s==0)
        c++; 
        if(h.containsKey(s)) 
        { 
            c+=h.get(s); 
            int k=h.get(s); 
            k++;
            h.put(s,k); 
            
        }
        else h.put(s,1);
        } return c;
    

}
   }
