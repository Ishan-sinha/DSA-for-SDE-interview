/*


Sort an array of 0s, 1s and 2s 

Given an array of size N containing 0s, 1s, and 2s; sort the array in ascending order.

Input:
First line of input contains number of testcases T. For each testcase, there will be two lines, first of which will contain N. The second lines contains the elements of the array.

Output: 
Print sorted array.

Your Task:
Complete the function sort012() that takes array and n and sorts the array in place. 

Constraints: 
1 <= T <= 50
1 <= N <= 10^5
0 <= A[i] <= 2 */

//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {

public static void sort012(int a[], int n){
    // code here 
    int a0=0,a1=0,a2=0;
    for(int i=0;i<n;i++){
        if(a[i]==0) a0++;
        if(a[i]==1) a1++;
        if(a[i]==2) a2++;
    }
    for(int i=0;i<n;i++){
        if(i<a0) a[i]=0;
        else if(i<(a0+a1)) a[i] = 1;
        else a[i] = 2;
    }
    
}

// { Driver Code Starts.

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends