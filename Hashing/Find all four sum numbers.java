/*
Find all four sum numbers 

Given an array A of size N, find all combination of four elements in the array whose sum 
is equal to a given value K. For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} 
and K = 23, one of the quadruple is “3 5 7 8” (3 + 5 + 7 + 8 = 23).

The output should contain only unique quadrples  For example, if input array is 
{1, 1, 1, 1, 1, 1} and K = 4, then output should be only one quadrple {1, 1, 1, 1}.

Note: Print -1 if no such quadruple is found. 
 

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test 
cases follow. Each test case contains two lines. The first line of input contains two integers 
N and K. Then in the next line are N space separated values of the array.

Output:
For each test case in a new line print all the quadruples present in the array separated by space which 
sums up to value of K. Each quadruple is unique which are separated by a delimeter "$" and are in increasing order. */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String line[] = br.readLine().split(" ");
		    int n = Integer.parseInt(line[0]);
		    int sum = Integer.parseInt(line[1]);
		    line = br.readLine().split(" ");
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = Integer.parseInt(line[i]);
		    }
		    Arrays.sort(arr);
		    HashSet<String> set = new HashSet<String>();
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < n - 3; i++) {
                for (int j = i + 1; j < n - 2; j++) {
                    for (int k = j + 1; k < n - 1; k++) {
                        for (int l = k + 1; l < n; l++) {
                            if (arr[i] + arr[j] + arr[k] + arr[l] == sum) {
                                String res = arr[i]+" "+arr[j]+" "+arr[k]+" "+arr[l]+" "+"$";
                                if(!set.contains(res)){
                                    set.add(res);
                                    sb.append(res);
                                }
                            }
                        }
                    }
                }
            }
            if(sb.length()==0)
                System.out.println(-1);
            else
                System.out.println(sb);
		}
	}
}