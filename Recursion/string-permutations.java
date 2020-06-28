/*
String Permutations 

Given a string S. The task is to print all permutations of a given string.

Input Format:
The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.

Output Format:
For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.

Your Task:
This is a function problem. You only need to complete the function permutation that takes S as parameter and prints the permutations in lexicographically increasing order. The newline is automatically added by driver code.

Constraints:
1 ≤ T ≤ 100
1 ≤ size of string ≤ 5

Expected Time Complexity: O(N * N!), N = length of string.
Expected Auxiliary Space: O(1) */

class Permutation
{
    public ArrayList<String> al1 = new ArrayList<>();
    public void permutation(String s)
    {
        //Your code here
        int l =0,r=s.length()-1;
        ArrayList<String> al = getPerm(s,l,r);
        Collections.sort(al);
        for(String s1:al)
            System.out.print(s1+" ");
    }
    public String swap(String s,int i,int j)
    {
        char[] ch = s.toCharArray();
        char t = ch[i];
        ch[i] = ch[j];
        ch[j]= t;
        return String.valueOf(ch);
    }
    public ArrayList<String> getPerm(String s,int l,int r)
    {
        if(l == r)
        {
            al1.add(s);
        }
        else {
        for(int i=l;i<=r;i++)
        {
                s = swap(s,l,i);
                getPerm(s,l+1,r);
                s = swap(s,l,i);
        } }
        return al1;
    }  
}