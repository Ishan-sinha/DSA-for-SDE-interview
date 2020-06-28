/*
Combination Sum

Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B.

ach number in A may only be used once in the combination.

Note:
   All numbers will be positive integers.
   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
   The combinations themselves must be sorted in ascending order.
   If there is no combination possible the print "Empty" (without qoutes).
Example,
Given A = 10,1,2,7,6,1,5 and B(sum) 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

Input:
First is T , no of test cases. 1<=T<=500
Every test case has three lines.
First line is N, size of array. 1<=N<=12
Second line contains N space seperated integers(x). 1<=x<=9.
Third line is the sum B. 1<=B<=30.
 
Output:
One line per test case, every subset enclosed in () and in every set intergers should be space seperated. */

/*package whatever //do not write package name here */

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
		    int a[] = new int[n]; 
		    for(int i=0;i<n;i++){
		        a[i] = sc.nextInt();
		    }
		    int sum = sc.nextInt();
		    Arrays.sort(a);
		   ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); //All combinations
		   ArrayList<Integer> res = new ArrayList<>(); //One combination
		   combinationsForSum(ans,res,a,n,sum,0);
		   
		   StringBuffer sb = new StringBuffer();
		   //Now printing with brackets
		   for(int i=0;i<ans.size();i++)
		   {
		       sb.append("(");
		       for(int j=0;j<ans.get(i).size();j++)
		       {
		           if(j!=ans.get(i).size()-1)
		            sb.append(ans.get(i).get(j)+" ");
		            
		            else 
		            sb.append(ans.get(i).get(j));
		       }
		       
		       sb.append(")");
		   }
		   
		   if(ans.size()==0) sb.append("Empty");
		   System.out.println(sb);
		    
		}
	}
	static void combinationsForSum(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> res,int a[],int n,int sum,int cur)
	{
	   if(sum==0)  //Base case1  (sum==0 means we found a match so add pair and return)
	   {
	       ans.add(new ArrayList<Integer>(res));
	       return;
	   }
	   
	   //CODE WILL WORK WITHOUT BASE CASE -2.
	    if(sum<0)  //Base case 2  (sum-a[i]<0  then simply return)
	       return;
	   
	   for(int i=cur;i<n;i++)
	   {
	       if(i>cur && a[i]==a[i-1]) continue; //Skip loop for duplicates. (i>index bcs we want to start detecting duplicates 
	                                           //from the 2nd round of looping as in the 1st loop there is no previous.)
	       res.add(a[i]);
	       combinationsForSum(ans,res,a,n,sum-a[i],i+1);
	       res.remove(res.size()-1); //remove last element.
	   }
	}
}