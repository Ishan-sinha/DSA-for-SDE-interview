/*
Sorting Elements of an Array by Frequency 

Given an array A[] of integers, sort the array according to frequency of elements. That is elements
 that have higher frequency come first. If frequencies of two elements are same, then smaller number 
 comes first.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T 
test cases follows. The first line of each test case contains a single integer N denoting the size of 
array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space. */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    //Arrays.sort(arr);
		//ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<Integer,Integer>();
		for(int i=0;i<n;i++)
		{
		    if(!hm.containsKey(arr[i])){
		        hm.put(arr[i],1);
		    }
		    else{
		        hm.put(arr[i],hm.get(arr[i])+1);
		    }
		}
		for(int i=0;i<n-1;i++){
		    for(int j=i+1;j<n;j++){
		        if(hm.get(arr[i])<hm.get(arr[j]) || hm.get(arr[i])==hm.get(arr[j]) && arr[i]>arr[j]){
		            int temp=arr[i];
		            arr[i] = arr[j];
		            arr[j] = temp;
		        }
		    }
		}
		for(int i=0;i<n;i++){
		    System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	}
}