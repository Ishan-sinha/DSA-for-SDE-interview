/*
Problem Statement:
Given an array of n elements, where each element is
at most k away from its target position. The task is
to print array in sorted form.
Input:
2
3 3
2 1 3
6 3
2 6 3 12 56 8
Output:
1 2 3
2 3 6 8 12 56
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class main
 {
	public static void main (String[] args)
	 {
	 
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-- > 0)
	 {
	     int n=sc.nextInt();
	     int k=sc.nextInt();
	     int a[]=new int[n];
	     for(int i=0;i<n;i++)
	     a[i]=sc.nextInt();
	     PriorityQueue<Integer> pq=new PriorityQueue<>();
	     int index=0;
	     if(n==k)
	     {
	     for(int i=0;i<k;i++)
	     pq.add(a[i]);
	     }
	     else
	     {
	        for(int i=0;i<=k;i++)
	     pq.add(a[i]); 
	     }
	     for(int j=k+1;j<n;j++)
	     {
	         a[index++]=pq.poll();
	         pq.add(a[j]);
	     }
	     while(pq.isEmpty()==false)
	     a[index++]=pq.poll();
	     for(int i=0;i<n;i++)
	     System.out.print(a[i]+" ");
	     System.out.println();
	 }
	 }
}