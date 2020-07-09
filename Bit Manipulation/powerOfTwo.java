/*
Program to find whether a no is power of two
Given a positive integer, write a function to
find if it is a power of two or not.

Examples :

Input : n = 4
Output : Yes
22 = 4

Input : n = 7
Output : No

Input : n = 32
Output : Yes
25 = 32
*/

import java.lang.*;
import java.io.*;
class main
 {
	public static void main (String[] args)
	 {
	
	 Scanner sc= new Scanner(System.in);
int t=sc.nextInt();
while(t-->0){
String str=sc.next();
long n=Long.parseLong(str);
long temp=n-1;
if(n==0){
System.out.println("NO");
break;
}
if((n & n-1)==0)
System.out.println("YES");
else
System.out.println("NO");


}


	 }
}