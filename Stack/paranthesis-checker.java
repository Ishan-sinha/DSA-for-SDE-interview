/*

Parenthesis Checker 

Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”

Input:
The first line of input contains an integer T denoting the number of test cases.  
Each test case consists of a string of expression, in a separate line.

Output:
Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ |s| ≤ 105

Example:
Input:
3
{([])}
()
([]

Output:
balanced
balanced
not balanced */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
		Stack<Character> st = new Stack<Character>();
        char[] exp = sc.next().toCharArray(); 
        int flag = 1;
        for(int i=0;i<exp.length;i++)
        {
            if(exp[i]=='('||exp[i]=='{'||exp[i]=='[')
                st.push(exp[i]);
            else if(!st.empty() && ((st.peek()=='(' && exp[i]==')')||(st.peek()=='{' && exp[i]=='}')||(st.peek()=='[' && exp[i]==']')))
                st.pop();
            else{
                flag=0;
                break;
            }
        }
        if(flag==1 && st.empty()==true)
            System.out.println("balanced");
        else
            System.out.println("not balanced");
		}
	}
}