/*
Flood fill Algorithm

Given a 2D screen, location of a pixel in the screen ie(x,y) and a color(K), your task is to replace color of the given pixel and all adjacent(excluding diagonally adjacent) same colored pixels with the given color K.

Example:

{{1, 1, 1, 1, 1, 1, 1, 1},
{1, 1, 1, 1, 1, 1, 0, 0},
{1, 0, 0, 1, 1, 0, 1, 1},
{1, 2, 2, 2, 2, 0, 1, 0},
{1, 1, 1, 2, 2, 0, 1, 0},
{1, 1, 1, 2, 2, 2, 2, 0},
{1, 1, 1, 1, 1, 2, 1, 1},
{1, 1, 1, 1, 1, 2, 2, 1},
 };

 x=4, y=4, color=3 

{{1, 1, 1, 1, 1, 1, 1, 1},
{1, 1, 1, 1, 1, 1, 0, 0},
{1, 0, 0, 1, 1, 0, 1, 1}, 
{1, 3, 3, 3, 3, 0, 1, 0},
{1, 1, 1, 3, 3, 0, 1, 0},
{1, 1, 1, 3, 3, 3, 3, 0},
{1, 1, 1, 1, 1, 3, 1, 1},
{1, 1, 1, 1, 1, 3, 3, 1}, };

Note: Use zero based indexing.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains Two integers N and M denoting the size of the matrix. Then in the next line are N*M space separated values of the matrix. Then in the next line are three values x, y and K.

Output:
For each test case print the space separated values of the new matrix.

Constraints:
1 <= T <= 100
1 <= M[][] <= 100 */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++)
		{
		int n=sc.nextInt();
		int m=sc.nextInt();
		int arr[][]=new int[n][m];
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		    {
		        arr[i][j]=sc.nextInt();
		    }
		
		}
		int x=sc.nextInt();
		int y=sc.nextInt();
		int k=sc.nextInt();
		int val=arr[x][y];
		changearr(arr,x,y,k,n,m,val);
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		    {
		        System.out.print(arr[i][j]+" ");
		    }
		
		}
		System.out.println();
		}
	
}
    private static void changearr(int arr[][],int x,int y,int k,int n,int m,int val)
    {
        arr[x][y]=k;
        if((y-1>=0)&&(arr[x][y-1]==val))
        {
            changearr(arr,x,y-1,k,n,m,val);
        }
        if((y+1<m)&&(arr[x][y+1]==val))
        {
            changearr(arr,x,y+1,k,n,m,val);
        }
        if((x-1>=0)&&(arr[x-1][y]==val))
        {
            changearr(arr,x-1,y,k,n,m,val);
        }
        if((x+1<n)&&(arr[x+1][y]==val))
        {
            changearr(arr,x+1,y,k,n,m,val);
        }
    }
}