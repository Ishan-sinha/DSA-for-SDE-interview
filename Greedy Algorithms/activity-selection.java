/*

Activity Selection 

Given N activities with their start and finish times. Select the maximum number of activities that can 
be performed by a single person, assuming that a person can only work on a single activity at a time.

Note : The start time and end time of two activities may coincide.

Input:
The first line contains T denoting the number of testcases. Then follows description of testcases. First line 
is N number of activities then second line contains N numbers which are starting time of activies.Third line 
contains N finishing time of activities.

Output:
For each test case, output a single number denoting maximum activites which can be performed in new line.

Constraints:
1<=T<=50
1<=N<=1000
1<=A[i]<=100   */


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static class pair{
         int start;
         int finish;
    }
    
    static class CustomSort implements Comparator<pair>
    {
        public int compare(pair p1,pair p2)
        {
            if(p1.finish>p2.finish) return 1;
            
            return -1;
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
	    while(t-- >0)
	    {
	        int n = sc.nextInt();
	        int start[] = new int[n];
	        int finish[] = new int[n];
	        for(int i=0;i<n;i++)
	            start[i] = sc.nextInt();
	        for(int i=0;i<n;i++)
	            finish[i] = sc.nextInt();
	        System.out.println(activity(start,finish,n));
	    }
	}
	static int activity(int s[],int f[],int n)
		{
		   ArrayList<pair>al = new ArrayList<>();
		   for(int i=0;i<n;i++)
		   {
		       pair p = new pair();
		       p.start = s[i];
		       p.finish = f[i];
		       al.add(p);
		       
		   }
		   
		   Collections.sort(al,new CustomSort());
		   
		   int end = Integer.MIN_VALUE;
		   int count =0;
		   for(int i=0;i<al.size();i++)
		   {
		       pair p = al.get(i);
		        if(p.start >= end)
		       {
		          count++;
		          end = p.finish;
		       }
		      
		   }
		   return(count);
		}
}