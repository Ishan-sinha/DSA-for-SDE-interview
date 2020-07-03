/*

Largest number possible 

Given two numbers 'N' and 'S' , find the largest number that can be formed 
with 'N' digits and whose sum of digits should be equals to 'S'.

Input:
The first line of input contains an integer T denoting the number of test cases. 
Then T test cases follow. The first line of each test case contains two space 
separated integers N and S, where N is the number of digits and S is the sum.

Output:
Print the largest number that is possible.If their is no such number, then print -1 

Constraints:
1 <= T <= 30
1 <= N <= 50
0 <= S <= 500

Example: 
Input:
2
2 9
3 20
Output: 
90
992  */


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
		    String[] input = br.readLine().split("\\s+");
		    int n = Integer.parseInt(input[0]);
		    int s = Integer.parseInt(input[1]);
		    
		    printLargeNumber(n, s);
		}
	}
    public static void printLargeNumber(int n, int s){
        float f = ((float)s/(float)n);
        if(f>0 && f<=9){
            for(int i=0; i<n; i++){
                if(s/9 > 0){
                    System.out.print("9");
                    s-=9;
                }else{
                    System.out.print(s%10);
                    s = 0;
                }
            }
        }
        else{
            System.out.print("-1");
        }
        System.out.println();
    }
}