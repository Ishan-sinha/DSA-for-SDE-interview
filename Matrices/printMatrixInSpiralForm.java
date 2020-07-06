/*
Example:
Input:
2
4 4
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
3 4
1 2 3 4 5 6 7 8 9 10 11 12

Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
1 2 3 4 8 12 11 10 9 5 6 7


*/

import java.util.*;
import java.lang.*;
import java.io.*;
class main
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-- > 0)
	 {
	     int r=sc.nextInt();
	     int c=sc.nextInt();
	     int a[][]=new int[r][c];
	     for(int i=0;i<r;i++)
	     {
	         for(int j=0;j<c;j++)
	         a[i][j]=sc.nextInt();
	         
	     }
	     int top=0,left=0,bottom=r-1,right=c-1;
	     while(top<=bottom && left<=right)
	     {
	         for(int i=left;i<=right;i++)
	         System.out.print(a[top][i]+" ");
	         top++;
	         for(int i=top;i<=bottom;i++)
	         System.out.print(a[i][right]+" ");
	         right--;
	         if(top<=bottom)
	         {
	            for(int i=right;i>=left;i--)
	         System.out.print(a[bottom][i]+" ");
	         bottom--; 
	         }
	         if(left<=right)
	         {
	            for(int i=bottom;i>=top;i--)
	         System.out.print(a[i][left]+" ");
	         left++; 
	         }
	     }
	     System.out.println();
	 }
	 }
}