/*

Distinct absolute array elements 

Count the number of distinct absolute values from a sorted array containing N integers. An absolute value of a number is | a |  ( positive ) value of it.
 

Input
The first line of input contains an integer T denoting the number of test cases. Then T test cases
follow. 
The first line of each test case contains an integer N, where N is the size of the array A[ ].
The second line of each test case contains N space separated sorted integers, denoting elements of the array
A[ ].

Note: The array can contain duplicate values.
 

Output:
For each test case output a single line containing the no of distinct absolute values present in the array .
Remember to output the answer of each test case in a new line.
 

Constraints:
1 <= T <= 100
1 <= N <= 30
-10^9<= A[i] <= 3*10^9        */


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    HashSet<Integer> hs = new HashSet<>();
		    for(int i=0;i<n;i++){
		        arr[i] = Math.abs(sc.nextInt());
		        hs.add(arr[i]);
		    }
		    System.out.println(hs.size());
		}
	}
}