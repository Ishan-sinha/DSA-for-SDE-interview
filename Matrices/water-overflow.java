/*

Water Overflow 

There is a stack of water glasses in a form of pascal triangle and a person wants to pour the water 
at the topmost glass, but the capacity of each glass is 1 unit. Overflow takes place in such a way 
that after 1 unit, 1/2 of remaining unit gets into bottom left glass and other half in bottom right 
glass.Now the pours K units of water in the topmost glass and wants to know how much water is there 
in the jth glass of the ith row.

Note: Assume that there are enough glasses in the triangle till no glass overflows. 

Input:
First line of the input contains an integer T denoting the number of test cases and each test case consists 
of three lines. First line contain an integer K, second line contains an integer i and third line contains an integer j.

Output:
Corresponding to each test case output the remaining amount of water in jth cup of the ith row correct to 6 decimal places.

Constraints:
1 <= T<=20
1 <= K <= 1000
1 <= i <= K
1 <= j<= K  */

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc = new Scanner(System.in);
	 int t = sc.nextInt();
	 while(t-->0) {
	     int k = sc.nextInt();
	     int i = sc.nextInt()-1;
	     int j = sc.nextInt()-1;
	     float glass[][] = new float[1000][1000];
	     float f = (float)k;
	     helper(f, glass, 0, 0);
	     System.out.println(glass[i-j][j]);
	 }
    }
    
	 public static void helper(float k, float glass[][], int i, int j) {
	     if(glass[i][j]+k<=1) {
	         glass[i][j] += k;
	         return;
	     } else {
	         float spill = glass[i][j]+k-1;
	         glass[i][j] = 1;
	         helper(spill/2, glass, i, j+1);
	         helper(spill/2, glass, i+1, j);
	     }
	 }
}