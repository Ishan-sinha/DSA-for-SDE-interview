/*
Merge k Sorted Arrays 

Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.

Input:
The first line of input contains the number of test cases, then T test cases follow. Each test case will contain an integer K denoting the number of sorted arrays(each with size K). Then in the next line contains all the elements of the array separated by space.

Output:
The output will be the sorted merged array.

User Task:
You need to complete mergeKArrays() function which takes 2 arguments, an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the number of sorted arrays. The function should return a pointer to the merged sorted arrays.

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)  */



import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


class Solution{
    public static ArrayList<Integer> mergeKArrays(int[][] a, int k) 
    {
        // Write your code here.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        for(int i = 0; i<k ; i++){
            int j = 0;
            while(j<k){ 
                pq.add(a[i][j++]);
            }
            
        }
        while(pq.size()>0){
            arr1.add(pq.peek());
            pq.remove();
        }
        return arr1;
    }
}
