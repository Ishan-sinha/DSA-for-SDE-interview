/*
Problem Statement:
Given an array of N positive integers, print k largest elements from the array.  The output elements should be printed in decreasing order.
Example:
Input:
2
5 2
12 5 787 1 23
7 3
1 23 12 9 30 2 50

Output:
787 23
50 30 23

Approach : Store the elements in a Max Heap(Use Priority Queue in Java).
Traverse the heap for k times and the print the root node of the Max
Heap.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class Main
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
	     PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());// By default Priority Queue defines a Min Heap so
// for creating a Max Heap use Collections.reverseOrder()
	     for(int i=0;i<n;i++)//Add the elements of array to Max Heap
	     pq.add(a[i]);
	     for(int i=0;i<k;i++)//Traverse the heap for k times
	     System.out.print(pq.poll()+" ");//Print the greatest elements.
	     System.out.println();
	 }
	 
	 }
}