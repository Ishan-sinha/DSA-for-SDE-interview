/*
Largest subarray with 0 sum 
Given an array having both positive and negative integers. 
The task is to compute the length of the largest subarray with sum 0.

Input:
The first line of input contains an element T denoting the number of test cases. Then T test cases follow. 
Each test case consists of 2 lines. The first line of each test case contains a number denoting the size of 
the array A. Then in the next line are space-separated values of the array A.

Output:
For each test case, the output will be the length of the largest subarray which has sum 0.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function 
maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length 
of the largest subarray with 0 sum.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(N). */

import java.util.*;
import java.io.*;

class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
			}
			Solution s = new Solution();
			System.out.println(s.maxLen(arr,n));
		}
	}
}
class Solution
{
	int maxLen(int arr[],int n)
	{
		int maxLength = 0, prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0)
                maxLength = i + 1;
            Integer index = map.get(prefixSum);
            if (index == null)
                map.put(prefixSum, i);
            else
                maxLength = Math.max(maxLength, i - index);
        }
        return maxLength;
	}
}