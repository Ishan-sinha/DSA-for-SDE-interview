/*

Minimize the heights
 
Given an array A[ ] denoting heights of N towers and a positive integer K, modify the heights of each tower 
either by increasing or decreasing them by K only once and then find out the minimum difference of the heights 
of shortest and longest towers.

Example

Input  : A[] = {1, 15, 10}, k = 6
Output : 5
Explanation : We change 1 to 7, 15 to 
9 and 10 to 4. Maximum difference is 5
(between 4 and 9). We can't get a lower
difference.

Input
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first 
line of each test case contains a positive integer K. The second line of each test case contains a positive integer N, 
denoting number of towers. The third line of the test cases contains N integers denoting the heights of N towers.

Output
For each test case in new line print out the minimum difference of heights possible.

Constraints
1 <= T <= 100
0 <   K <= 30
0 <   N <= 30
0 <= A[i] <= 500   */

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
		    int k = sc.nextInt();
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		        arr[i] = sc.nextInt();
		    Arrays.sort(arr);
		    int mid = (arr[0]+arr[n-1])/2;
		    if((arr[n-1]-arr[0])>k){
		        for(int i=0;i<n;i++){
		            if(arr[i]<mid) arr[i] += k;
		            else arr[i] -= k;
		        }
		   Arrays.sort(arr);
		   System.out.println(arr[n-1]-arr[0]);
		    }
		    else
		        System.out.println(arr[n-1]-arr[0]);
		}
	}
}