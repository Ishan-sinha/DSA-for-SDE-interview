/*
Case-specific Sorting of Strings 

Given a string S consisting of uppercase and lowercase characters. The task is to sort uppercase 
and lowercase letters separately such that if the ith place in the original string had an Uppercase 
character then it should not have a lowercase character after being sorted and vice versa.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T 
test cases follows. The first line of each test case contains a single integer N denoting the length 
of string. The second line contains a string S of length N, consisting of uppercase and lowercase characters.

Output:
For each testcase, in a new line, print the answer.

Your Task:
This is a function problem. You only need to complete the function caseSort that returns sorted string.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(N).       */



import java.util.*;
import java.lang.*;
import java.io.*;

class solve{
    public static String caseSort(String str) {
        // Your code here
        Queue<Character> lower = new PriorityQueue<>();
        Queue<Character> upper = new PriorityQueue<>();
        
        for(int i = 0; i < str.length(); ++i) {
            
            if(Character.isLowerCase(str.charAt(i)))
                lower.add(str.charAt(i));
            else
                upper.add(str.charAt(i));
        }
        
        String ans = "";
        
        for(int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            
            if(Character.isLowerCase(c))
                ans += lower.remove();
            else
                ans += upper.remove();
        }
        
        return ans;
    }
}


class GFG {
    
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new solve().caseSort(str);
    	        System.out.println(sortedStr);
    	    }
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}