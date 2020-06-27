/*
Relative Sorting 

Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a 
way that the relative order among the elements will be same as those in A2. For the elements 
not present in A2, append them at last in sorted order. It is also given that the number of 
elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct 
elements.
Note: Expected time complexity is O(N log(N)).

Input:
First line of input contains number of testcases. For each testcase, first line of input contains
length of arrays N and M and next two line contains N and M elements respectively.

Output:
Print the relatively sorted array.
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    public static void main (String[] args) throws IOException
	    {
	    // Using BufferedReader class to take input 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
	    // taking input of number of testcase 
        int t = Integer.parseInt(br.readLine()); 
        
	    while(t-- > 0) {

            // to read multiple integers line 
            String line = br.readLine(); 
            String[] strs = line.trim().split("\\s+"); 
            int n = Integer.parseInt(strs[0]);
            int m = Integer.parseInt(strs[1]);

            line = br.readLine(); 
            strs = line.trim().split("\\s+"); 
            // Declaring array 
            int arr1[] = new int[n]; 
            // array elements input 
            for (int j = 0; j < n; j++) 
                arr1[j] = Integer.parseInt(strs[j]);
            line = br.readLine(); 
            strs = line.trim().split("\\s+");     
            int arr2[] = new int[m];
            for (int j = 0; j < m; j++) 
                arr2[j] = Integer.parseInt(strs[j]);
                
            Map<Integer, Integer> lookup = new TreeMap<>(); // map to keep count in sorted order
            for(int e: arr1) {
                lookup.merge(e, 1, Integer::sum); // if exist increment count
            }
            for(int e: arr2) {
                if(lookup.containsKey(e)) {
                    while(lookup.get(e) > 0) {
                        System.out.print(e + " ");
                        lookup.merge(e, -1, Integer::sum);
                    }
                    lookup.remove(e);
                }
            }
            for(int e: lookup.keySet()) {
                while(lookup.get(e) > 0) {
                        System.out.print(e + " ");
                        lookup.merge(e, -1, Integer::sum);
                    }
		    }
            System.out.println(); // new line for next testcase
	    }
	 }
}