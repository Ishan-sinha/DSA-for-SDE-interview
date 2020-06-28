/*
Lucky Numbers 

Lucky numbers are subset of integers. Rather than going into much theory, let us see the process of arriving at lucky numbers,
Take the set of integers
1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,……
First, delete every second number, we get following reduced set.
1, 3, 5, 7, 9, 11, 13, 15, 17, 19,…………
Now, delete every third number, we get
1, 3, 7, 9, 13, 15, 19,….….
Continue this process indefinitely……
Any number that does NOT get deleted due to above process is called “lucky”.

Your task is to complete isLucky function.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N. 

Output:
For each testcase, in a new line, print 1 if the given number is a lucky number, else print 0.

Your Task:
This is a function problem. You only need to complete the function isLucky that takes n as parameter and returns either 0 or 1.

Expected Time Complexity: O(sqrt(n)). */

class Solution
{
    // Complete the function
    // n: Input n
    // counter: variable has already been declared in driver code
    //          you just have to use this variable.
    static int counter = 2;
    
    // Return True if the given number is a lucky number else return False
    public static boolean isLucky(int n)
    {
        if(counter > n)
            return true;
        if(n%counter==0)
            return false;
        int np = n-(n/counter);
        counter++;
        return isLucky(np);
    }
}