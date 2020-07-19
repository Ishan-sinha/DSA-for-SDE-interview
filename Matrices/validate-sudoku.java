/*

Is Sudoku Valid 

Given an incomplete Sudoku configuration in terms of a 9x9  2-D square matrix (mat[][]) the task to check if the configuration has a solution or not. 

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains 9*9 space separated values of the matrix mat[][] representing an incomplete Sudoku state where a 0 represents empty block.

Output:
For each test case in a new line print 1 if the sudoku configuration is valid else print 0.

Constraints:
1<=T<=10
0<=mat[]<=9 */

import java.util.*;
import java.lang.*;
import java.io.*;

class Test {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		try
		{
		    int t = sc.nextInt();
		    while(t-->0)
		    {
				int a[][]=new int[9][9];
				for(int i=0;i<9;i++)
				   for(int j=0;j<9;j++)
					 a[i][j] = sc.nextInt();
					
			    System.out.println(isSudokuValid(a));
			}    
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
	}
	static int isSudokuValid(int a[][]){
		
	 HashSet<Integer>sudoku1=new HashSet<Integer>();
	 HashSet<Integer>sudoku2=new HashSet<Integer>();
	 for(int i=0;i<9;i++){
		 for(int j=0;j<9;j++){
			 if(a[i][j] !=0 && (sudoku1.contains(a[i][j])))
				return 0;
		   	else
			sudoku1.add(a[i][j]);
			
			if(a[j][i]!=0 && (sudoku2.contains(a[j][i])))
			  return 0;
			else
			 sudoku2.add(a[j][i]);
		 }
		 sudoku1.clear();
		 sudoku2.clear();
	 }
	   return 1;
	}
}