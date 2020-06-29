/*
Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.

Input:
The first line of input contains the number of testcase T. For each testcase, the first line of input contains the number of nodes in the linked list and the number N. The next line contains L nodes of the linked list.

Output:
For each testcase, output the data of node which is at Nth distance from the end or -1 in case node doesn't exist.

User Task:
The task is to complete the function getNthFromLast() which takes two arguments: reference to head and N and you need to return Nth from the end.

Note:
Try to solve in single traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 200
1 <= L <= 103
1 <= N <= 103

Example:
Input:
2
9 2
1 2 3 4 5 6 7 8 9
4 5
10 5 100 5
Output:
8
-1
*/

class main
{
    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    int getNthFromLast(Node head, int n)
    {
    	
    Node s=head;
    for(int i=0;i<n;i++)
    {
        if(s==null)
        return -1;
        s=s.next;
    }
    Node f=head;
    while(s!=null)
    {
        f=f.next;
        s=s.next;
    }
    return f.data;
    }
}