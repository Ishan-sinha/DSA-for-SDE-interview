/*
Sort a stack 

Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Input:
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. 
Each test case contains an integer N denoting the size of the stack. Then in the next line are N space separated values which are pushed to the the stack. 

Output:
For each test case output will be the popped elements from the sorted stack.

Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack.

Expected Time Complexity : O(N*N)
Expected Auixilliary Space : O(N) recursive.  */

import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
	    if(s == null || s.isEmpty()) {
		    return s;
		}
		
		Stack<Integer> s1 = new Stack<>();
		Integer topS = null;
		while (!s.isEmpty()) {
		    topS = s.pop();
		    while(!s1.isEmpty() && topS < s1.peek()) {
		            s.push(s1.pop());
		    }
		    s1.push(topS);
		}
		
		return s1;
	}
}