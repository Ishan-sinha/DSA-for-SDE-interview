/*
Counting Sort 


Given a string S consisting of lowercase latin letters, arrange all its letters in lexographical order using Counting Sort.

Input:
The first line of the input contains T denoting number of testcases.Then T test cases follow. Each testcase contains positive integer N denoting the length of string.The last line of input contains the string S.

Output:
For each testcase, in a new line, output the sorted string.

Your Task:
This is a function problem. You only need to complete the function countSort() that takes char array as parameter and return the sorted char array. The printing is done by driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 105
1 <= N <= 105 */


class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            char seq[] = new char[(int)n+1];
            String str = "";
            str = sc.next();
            seq = str.toCharArray();
            GfG gfg = new GfG();
            System.out.println(gfg.countSort(seq));
        }
    }
}


class GfG
{
    
    public static char[] countSort(char seq[])
    {
        // add your code here 
        int t[] = new int[26];
        Arrays.fill(t,0);
        for(int i=0;i<seq.length;i++){
            t[seq[i]-97]++;
        }
        char p = 'a';
        String q="";
        for(int i=0;i<26;i++){
            for(int j=0;j<t[i];j++){
                q += p;
            }
            ++p;
        }
        char c[] = q.toCharArray();
        return c;
    }
}