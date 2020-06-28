/*
Josephus problem 

Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle in a fixed direction.​
The task is to choose the safe place in the circle so that when you perform these operations starting from 1st place in the circle, you are the last one remaining and survive.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains 2 integers n and k .

Output:
For each test case, in a new line, output will be the safe position which satisfies the above condition.

Your Task:
This is a function problem. You are required to complete the function josephus () that takes two parameters n and k and returns an integer denoting safe position. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). */

import java.util.*;
import java.io.*;

class Recursion
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			Josephus obj = new Josephus();
			int n = sc.nextInt();
			int k = sc.nextInt();
			System.out.println(obj.josephus(n,k));
		}
	}
}
class Josephus
{
   public int josephus(int n, int k)
    {
        //Your code here
        return n==1 ? 1:((k + josephus(n-1, k) - 1)%n + 1);
    }

}