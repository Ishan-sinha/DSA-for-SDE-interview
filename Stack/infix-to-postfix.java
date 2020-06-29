/*
Infix to Postfix 

Given an infix expression in the form of string str. Conver this infix expression to postfix expression.

Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
​Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. 

Input:
The first line of input contains an integer T denoting the number of test cases. The next T lines contain 
an infix expression. The expression contains all characters and ^,*,/,+,-. 

Output:
For each testcase, in a new line, output the infix expression to postfix expression.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= length of str <= 103

Example:
Input:
2
a+b*(c^d-e)^(f+g*h)-i
A*(B+C)/D
Output:
abcd^e-fgh*+^*+i-
ABC+*D/

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new solve().infixToPostfix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class solve{
    public static int prec(char ch){
        switch(ch){
            case '+':
            case '-':return 1;
            case '*':
            case '/':return 2;
            case '^':return 3;
        }
        return -1;
    }
	public static String infixToPostfix(String exp) {
	    Stack<Character> s=new Stack<>();
	    String result="";
	    for(int i=0;i<exp.length();i++){
	        char ch=exp.charAt(i);
	        if(Character.isLetterOrDigit(ch))
	        result+=ch;
	        else if(ch=='(')
	        s.push(ch);
	        else if(ch==')'){
	            while(!s.isEmpty()&&s.peek()!='(')
	            result+=s.pop();
	            if(!s.isEmpty()&&s.peek()!='(')
	            return "Invalid Expression";
	            else
	            s.pop();
	        }
	        else{
	            while(!s.isEmpty()&&prec(ch)<=prec(s.peek()))
	            result+=s.pop();
	            s.push(ch);
	        }
	    }
	    while(!s.isEmpty())
	    result+=s.pop();
	    return result;
	} 
}