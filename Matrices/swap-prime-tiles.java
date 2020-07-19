/*
Swap prime tiles

Johnny has some difficulty memorizing the small prime numbers. So, his computer science teacher has asked him 
to play with the following puzzle game frequently.The puzzle is a 3x3 board consisting of numbers from 1 to 9. 
The objective of the puzzle is to swap the tiles until the following final state is reached:

1 2 3
4 5 6
7 8 9

At each step, Johnny may swap two adjacent tiles if their sum is a prime number. Two tiles are considered adjacent 
if they have a common edge.Help Johnny to find the shortest number of steps needed to reach the goal state.

Input
The first line contains t, the number of test cases (about 50). Then t test cases follow. Each test case consists 
of a 3x3 table describing a puzzle which Johnny would like to solve. The input data for successive test cases is 
separated by a blank line.

Output
For each test case print a single line containing the shortest number of steps needed to solve the corresponding 
puzzle. If there is no way to reach the final state, print the number -1.

Example
Input:
2

7 3 2 
4 1 5 
6 8 9 

9 8 5 
2 4 1 
3 7 6  

Output:
6
-1

*/

import java.util.*;
import java.lang.*;
import java.io.*;


class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[][] swap = {{0,1},{1,2},{3,4},{4,5},{6,7},{7,8},
		                {0,3},{1,4},{2,5},{3,6},{4,7},{5,8}};
		short[] seen = new short[98765433];
		int[] p10 = {100000000,10000000,1000000,100000,10000,1000,100,10,1};
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(123456789);
		seen[12345678] = 1;
		while(!arr.isEmpty()){
		    int x = arr.remove(0);
		    for(int i=0;i<swap.length;i++){
		        int a = x/p10[swap[i][0]]%10;
		        int b = x/p10[swap[i][1]]%10;
		        if(isPrime(a+b)){
		            int y = x+(b-a)*p10[swap[i][0]]+(a-b)*p10[swap[i][1]];
		            if(seen[y/10]==0){
		                arr.add(y);
		                seen[y/10] = (short)(seen[x/10]+1);
		            }
		        }
		    }
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int num = 0;
		    for(int i=0;i<9;i++){
		        num = num*10 + sc.nextInt();
		        
		    }
		    System.out.println(seen[num/10]-1);
		}
	}
	public static boolean isPrime(int x){
	    if(x==2||x==3||x==5||x==7||x==11||x==13||x==17) return true;
	    return false;
	}
}