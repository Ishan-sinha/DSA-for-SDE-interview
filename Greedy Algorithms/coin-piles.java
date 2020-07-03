/*

Coin Piles 

There are N piles of coins each containing  Ai (1<=i<=N) coins.  Now, you have to adjust the number of coins 
in each pile such that for any two pile, if a be the number of coins in first pile and b is the number of coins 
in second pile then |a-b|<=K. In order to do that you can remove coins from different piles to decrease the 
number of coins in those piles but you cannot increase the number of coins in a pile by adding more coins. Now, 
given a value of N and K, along with the sizes of the N different piles you have to tell the minimum number of 
coins to be removed in order to satisfy the given condition.
Note: You can also remove a pile by removing all the coins of that pile.

Input 
The first line of the input contains T, the number of test cases. Then T lines follow. Each test case contains two 
lines. The first line of a test case contains N and K. The second line of the test case contains N integers 
describing the number of coins in the N piles.

Output 
For each test case output a single integer containing the minimum number of coins needed to be removed in a new line.

Constraints              
1<=T<=50
1<=N<=100
1<=Ai<=1000
0<=K<=1000    

Example
Input           
3
4 0
2 2 2 2
6 3
1 2 5 1 1 1
6 3
1 5 1 2 5 1

Output        
0
1
2       */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int size = sc.nextInt();
		    int k = sc.nextInt();
		    int a[] = new int[size];
		    for(int i=0;i<size;i++)
		        a[i] = sc.nextInt();
		 Arrays.sort(a);
		 int minOverall = Integer.MAX_VALUE;
	     int removal=0;
	     for(int j=0;j<size-1;j++){
	        int min = a[j];
	        int counter=0;
	        if(j>0){
	            removal+=a[j-1];
	            counter+=removal;
	        }
	        for(int i=j+1; i<size; i++){
	            if((a[i]-min)>k){
	                counter+=a[i]-min-k;
	            }
	        }
	        minOverall = Math.min(minOverall,counter);
	     }
	     System.out.println(minOverall);
		}
	}
}