/*

Maximum Rectangular Area in a Histogram

Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of 
a number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.

Input:
The first line contains an integer 'T' denoting the total number of test cases. T test-cases follow. In each 
test cases, the first line contains an integer 'N' denoting the size of array. The second line contains N space
-separated integers A1, A2, ..., AN denoting the elements of the array. The elements of the array represents the height of the bars.

Output:
For each test-case, in a separate line, the maximum rectangular area possible from the contiguous bars.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A[i] <= 104

Example:
Input: 
2
7
6 2 5 4 5 1 6
4
6 3 4 2
Output:
12
9             */


import java.lang.*;
import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while (t > 0) {
	        int n = sc.nextInt();
	        long[] arr = new long[n];
	        
	        for (int i = 0; i < n; i++) {
	            arr[i] = sc.nextLong();
	        }
	        long area = maxArea(arr);
	        System.out.println(area);
	        t--;
	    }
	}
	
	public static long maxArea(long[] arr) {
	    Stack<Integer> stack = new Stack<>();
	    long maxArea = 0L;
	    int i = 0;
	    int n = arr.length;
	    
	    while (i < n) {
	        if (stack.isEmpty() || arr[i] >= arr[stack.peek()]) {
	            stack.push(i);
	            i++;
	        }
	        else {
	            int p = stack.pop();
	            long h = arr[p];
	            long w = (long)(stack.isEmpty() ? i : i - stack.peek() - 1);
	            maxArea = Math.max(maxArea, h * w);
	        }
	    }
	    
	    while (!stack.isEmpty()) {
	        int p = stack.pop();
	        long h = arr[p];
	        long w = stack.isEmpty() ? i : i - stack.peek() - 1;
	        maxArea = Math.max(maxArea, h * w);
	    }
	    
	    return maxArea;
	}
}
