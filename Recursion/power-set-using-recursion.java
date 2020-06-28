/*
Power Set Using Recursion 

You are given a string. You need to print the lexicographically sorted power-set of the string.
Note: The string s contains lowercase letter of alphabet.

Input:
The first line of input contains T, denoting the number of testcases. T testcases follow. Each testcases contains one line of input containing string s.

Output:
For each testcase, in a new line, print the lexicographically sorted sub-sets of the powerset of s. Each subset is separated by a space. Each subset starts with empty string.

Your Task:
This is a function problem. You only need to complete the function powerSet that takes string s as parameter and returns a list of subsets. The lexicographic-sorting and printing is done automatically by the driver code.

Expected Time Complexity: O(2|s|).
Expected Auxiliary Space: O(|s|). */

class LexSort
{
    static ArrayList<String> powerSet(String s)
    {
        ArrayList<String> subSets=new ArrayList<String>();
        subSets(s,"",0,subSets);
        return subSets;
    }

    static void subSets(String str,String subStr,int index,ArrayList<String> subs)
    {
        if (str.length() == index)
        {
            subs.add(subStr);
        } 
        else
        {
            subSets(str, subStr, index+1, subs);
            subSets(str, subStr + str.charAt(index), index+1, subs);
        }
    }
}