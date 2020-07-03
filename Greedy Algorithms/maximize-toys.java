/*

Maximize Toys 

Given an array consisting cost of toys. Given an integer K depicting the 
amount with you. Maximise the number of toys you can have with K amount.

Input:

The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains an integer N depicting the number of toys 
and an integer K depicting the value of K.
Next line is followed by the cost of toys.


Output:

Print the maximum toys in separate line.


Constraints:

1 ≤ T ≤ 30
1 ≤ N ≤ 1000
1 ≤ K ≤ 10000
1 ≤ A[i] ≤ 10000    */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0)
		{
		    int n = s.nextInt();
		    int k = s.nextInt();
		    int a[] = new int[n];
		    for(int i=0;i<n;i++)
		        a[i] = s.nextInt();
		    Arrays.sort(a);
		    int c = 0,x=0;
		    for(int i=0;i<n;i++){
		        if((c+a[i])<=k){
		            c+=a[i];
		            x++;
		        }
		        else break;
		    }
		    System.out.println(x);
		}
	}
}