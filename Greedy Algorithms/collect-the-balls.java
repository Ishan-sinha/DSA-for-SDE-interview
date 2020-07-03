/*

Geek collects the balls 

There are two parallel roads, each containing N and M buckets, respectively. Each bucket may contain 
some balls. The buckets on both roads are kept in such a way that they are sorted according to the 
number of balls in them. Geek starts from the end of the road which has the bucket with a lower number 
of balls(i.e. if buckets are sorted in increasing order, then geek will start from the left side of the road).
The geek can change the road only at the point of intersection(which means, buckets with the same number of 
balls on two roads). Now you need to help Geek to collect the maximum number of balls.

Input:
The first line of input contains T denoting the number of test cases. The first line of each test case contains 
two integers N and M, denoting the number of buckets on road1 and road2 respectively. 2nd line of each test case 
contains N integers, number of balls in buckets on the first road. 3rd line of each test case contains M integers, 
number of balls in buckets on the second road.

Output:
For each test case output a single line containing the maximum possible balls that Geek can collect.

Constraints:
1<= T <= 1000
1<= N <= 10^3
1<= M <=10^3
0<= A[i],B[i]<=10^6   */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc =new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- > 0)
		{
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int a[]=new int[n];
		    int b[]=new int[m];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    for(int i=0;i<m;i++)
		    {
		        b[i]=sc.nextInt();
		    }
		    int i=0,j=0;
		    int sum1=0,sum2=0;
		    int ans=0;
		    while(i<n && j<m)
		    {
		        if(a[i]<b[j])
		        {
		            sum1=sum1+a[i];
		            i++;
		        }
		        else if(a[i]>b[j])
		        {
		            sum2=sum2+b[j];
		            j++;
		        }
		        else
		        {
		          
		            int d=a[i];
		            
		            while(i<n &&  a[i]==d)
		            {
		                sum1=sum1+a[i];
		                i++;
		            }
		            while(j<m && b[j]==d)
		            {
		                sum2=sum2+b[j];
		                j++;
		            }
		            ans=ans+Math.max(sum1,sum2);
		            sum1=0;
		            sum2=0;
		        }
		    }
		    while(i<n)
		    {
		        sum1=sum1+a[i];
		        i++;
		    }
		    while(j<m)
		    {
		        sum2=sum2+b[j];
		        j++;
		    }
		    ans=ans+Math.max(sum1,sum2);
		    System.out.println(ans);
		}
	}
}