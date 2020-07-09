/*
Given an array of digits (values are from 0 to 9), find the minimum possible 
sum of two numbers formed from digits of the array. All digits of given array 
must be used to form the two numbers.
Example:

Input

2
6
6 8 4 5 2 3
5
5 3 0 7 4

Output

604
82

Explanation:

Test Case 1-

The minimum sum is formed by numbers 
358 and 246
Test Case 2 -

The minimum sum is formed by numbers 
35 and 047
*/

import java.lang.*;
import java.io.*;
class main
 {
	public static void main (String[] args)
	 {
	     Scanner sc=new Scanner(System.in);
	     int t=sc.nextInt();
	     for(int m=0;m<t;m++)
	     {
	         int n=sc.nextInt();
	         int i=0;
	         int arr[]=new int[n];
	         for(i=0;i<n;i++) arr[i]=sc.nextInt();
	         Arrays.sort(arr);
	         String one="";
	         String two="";
	         for(i=0;i<n;i+=2)
	         {
	             one=one+String.valueOf(arr[i]);
	         }
	         
	         for(i=1;i<n;i+=2)
	         {
	             two=two+String.valueOf(arr[i]);
	         }
	         
	         int sum=Integer.valueOf(one)+Integer.valueOf(two);
	         System.out.println(sum);
	     }
	 }
}