/*
Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.
Example:
Input:
4
5
15
1 
3
Output:
5
10
5
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
	
	     int n=sc.nextInt();
	     int a[]=new int[n];
	     for(int i=0;i<n;i++)
	     {
	         a[i]=sc.nextInt();
	     }
	    
	     PriorityQueue<Integer> g=new PriorityQueue<>();
	     PriorityQueue<Integer> s=new PriorityQueue<>(Collections.reverseOrder());
	     s.add(a[0]);
	     System.out.println(a[0]);
	     for(int i=1;i<n;i++)
	     {
	         int x=a[i];
	         if(s.size()>g.size())
	         {
	             if(s.peek()>x)
	             {
	                 g.add(s.poll());
	                 s.add(x);
	             }
	             else
	             g.add(x);
	            System.out.println((s.peek()+g.peek())/2);  
	         }
	         else
	         {
	             if(x<=s.peek())
	             s.add(x);
	             else{
	                 g.add(x);
	                 s.add(g.poll());
	             }
	             System.out.println(s.peek()); 
	         }
	     }
	     
	     
	     
	 }
}