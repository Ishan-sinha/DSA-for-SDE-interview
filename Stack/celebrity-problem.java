/*

The Celebrity Problem 

You are in a party of N people, where only one person is known to everyone. Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party. Your task is to find the stranger (celebrity) in party.

Input:
The first line of input contains an element T denoting the number of test cases. Then T test cases follow. Each test case consist of 2 lines. The first line of each test case contains a number denoting the size of the matrix M. Then in the next line are space separated values of the matrix M.

Output:
For each test case output will be the id of the celebrity if present (0 based index). Else -1 will be printed.

User Task:
You will be given a square matrix M[][] where if an element of row i and column j  is set to 1 it means ith person knows jth person. You need to complete the function getId() which finds the id of the celebrity if present else return -1. The function getId() takes two arguments, the square matrix M and its size N.

Note: 
M[i][i] will be equal to zero always.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 50
2 <= N <= 501
0 <= M[][] <= 1

Example:
Input :
2
3
0 1 0 0 0 0 0 1 0
2
0 1 1 0
Output :
1
-1

Explanation :
Testcase 1:
For the above test case the matrix will look like
0 1 0 
0 0 0
0 1 0
Here,  the celebrity is the person with index 1 ie id 1
Testcase 2:
The matrix will look like
0 1
1 0
Here, there is no such person who is a celebrity (a celebrity should know no one). */



//APPROACH I : USING STACK

import java.util.*;


class Celebrity_Problem
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					M[i][j] = sc.nextInt();
				}
			}
		System.out.println(new Celebrity().getId(M,N));
		t--;
		}
	}
}


class Celebrity
{

    int getId(int arr[][], int n)
    {
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<n;i++)
            st.push(i);
            
        while(st.size()>1)
        {
            int a = st.pop();
            int b = st.pop();
            if(arr[a][b]==0)
                st.push(a);
            else 
                st.push(b);
        }
        int x = st.pop();
        boolean flag = true;
        for(int i=0;i<n;i++){
            if(i==x) continue;
            if(arr[x][i]==1 || arr[i][x]==0) 
                flag = false;
        }
        if(flag==false)
            return -1;
        else
            return x;
    }
}



//APPROACH II : USING TWO-POINTER METHOD

import java.util.*;


class Celebrity_Problem
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++)
				{
					M[i][j] = sc.nextInt();
				}
			}
		System.out.println(new Celebrity().getId(M,N));
		t--;
		}
	}
}


class Celebrity
{
    int getId(int m[][], int n)
    {
        int a = 0;
        int b = n-1;
        while(a<b)
        { 
            if(m[a][b]== 1)
                a++;
            else 
                b--;
        }
        for(int i=0;i<n;i++){
            if((i!=a) && (m[a][i]== 1 || m[i][a]== 0))
                return -1;
        }
        return a;
    }
}
