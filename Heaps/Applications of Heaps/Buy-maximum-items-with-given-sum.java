/*
Given an array consisting cost of toys. Given an integer K
depicting the amount with you. Maximise the number of toys 
you can have with K amount.

Example:

Input
1
7 50
1 12 5 111 200 1000 10
Output
4
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
	     int count=0;
	     for(int i=0;i<n;i++)
	     pq.add(a[i]);
	     while(pq.peek()<=k && k!=0)
	     {
	         if(pq.peek()<k)
	         {
	         k=k-pq.poll();
	         count=count+1;
	         }
	         
	     }
	     System.out.println(count);
	 }
	 }
}