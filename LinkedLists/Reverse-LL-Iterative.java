/*
Given a linked list of N nodes. The task is to reverse this list.

Input:
The first line of input contains the number of test cases T. For each test case, the first line contains the length of the linked list and the next line contains the elements of the linked list.

Output:
For each test case, print the reversed linked list in a new line.

User Task:
The task is to complete the function reverseList() with head reference 
as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 104

Example:
Input:
2
6
1 2 3 4 5 6
5
2 7 8 9 10
Output:
6 5 4 3 2 1
10 9 8 7 2

Approach : Use three sliding pointers.
*/

class ReverseLL
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverseList(Node head)
   {
        // add code here
        Node p=head;
        Node q=null;
        Node r=null;
        while(p!=null)
        {
            r=q;
            q=p;
            p=p.next;
            q.next=r;
        }
        head=q;
        return head;
   }
}