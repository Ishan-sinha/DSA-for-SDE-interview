/*
Counting Sort 

Given a string S consisting of lowercase latin letters, arrange all its letters in lexographical order using Counting Sort.

Input:
The first line of the input contains T denoting number of testcases.Then T test cases follow. Each testcase contains positive integer N denoting the length of string.The last line of input contains the string S.

Output:
For each testcase, in a new line, output the sorted string.

Your Task:
This is a function problem. You only need to complete the function countSort() that takes char array as parameter and return the sorted char array. The printing is done by driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). */

import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            char seq[] = new char[(int)n+1];
            String str = "";
            str = sc.next();
            seq = str.toCharArray();
            GfG gfg = new GfG();
            System.out.println(gfg.countSort(seq));
        }
    }
}
// } Driver Code Ends


class GfG
{
    
    // Function to do count sort
    // seq[]: input array
    // return the sorted input array of character
    public static char[] countSort(char seq[])
    {
        // add your code here 
        TreeMap<Character, Integer> sorted = new TreeMap<>();
        for (int i = 0; i < seq.length; i++) {
            if (sorted.containsKey(seq[i])) {
                sorted.put(seq[i], sorted.get(seq[i]) + 1);
            } 
            else {
                sorted.put(seq[i], 1);
            }
        }
        int x = 0;
        for (Character s : sorted.keySet()) {
            for (int z = 1; z <= sorted.get(s); z++) {
                seq[x++] = s;
            }
        }
        return seq;
    }
}