/*
Count distinct elements in every window 
Given an array of integers and a number K. Find the count of distinct elements in every window of size K in the array.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two integers N and K. Then in the next line are N space separated values of the array A[].

Output:
For each test case in a new line print the space separated values denoting counts of distinct numbers in all windows of size k in the array A[]. */

import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			Solution g = new Solution();
			ArrayList<Integer> ans = new ArrayList<Integer>();
			ans = g.countDistinct(a,n,k);
			for(Integer val : ans){
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}
}
class Solution{
	ArrayList<Integer> countDistinct(int A[], int n, int k) {
        // code here 
        ArrayList<Integer> al = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int j = 0;
        for(int i=0;i<n;i++){
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            if(i+1>=k){
                al.add(map.size());
                if(map.containsKey(A[j]) && map.get(A[j])<=1)
                    map.remove(A[j]);
                else if(map.containsKey(A[j]) && map.get(A[j])>1) map.put(A[j],map.get(A[j])-1);
                j++;
            }
        }
        return al;
    }
}
