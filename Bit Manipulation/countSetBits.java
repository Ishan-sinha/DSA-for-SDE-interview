/*
Count set bits in an integer
Write an efficient program to count
number of 1s in binary representation of an integer.

Examples :

Input : n = 6
Output : 2
Binary representation of 6 is 110 and has 2 set bits

Input : n = 13
Output : 3
Binary representation of 13 is 1101 and has 3 set bits
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
int n=sc.nextInt();
int count=0;
while(n>0){
if((n & 1)==1)
count++;
n=n>>1;

}

System.out.println(count);
}
	 }
}