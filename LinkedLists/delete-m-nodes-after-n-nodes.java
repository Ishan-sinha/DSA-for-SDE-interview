/*
Given a linked list, delete N nodes after skipping M nodes of a linked list 
until the last of the linked list.

Input:
First line of input contains number of testcases T. For each testcase, first 
line of input contains number of elements in the linked list and next M and N 
respectively space separated. The last line contains the elements of the linked 
list.
*/
class Solution
{
    static void linkdelete(Node head, int M, int N)
    {
        // your code here
        Node curr = head, t;  
    int count;  
  
    // The main loop that traverses 
    // through the whole list  
    while (curr!=null)  
    {  
        // Skip M nodes  
        for (count = 1; count < M && curr != null; count++)  
            curr = curr.next;  
  
        // If we reached end of list, then return  
        if (curr == null)  
            return;  
  
        // Start from next node and delete N nodes  
        t = curr.next;  
        for (count = 1; count <= N && t != null; count++)  
        {  
            Node temp = t;  
            t = t.next;  
        }  
          
        // Link the previous list with remaining nodes  
        curr.next = t;  
  
        // Set current pointer for next iteration  
        curr = t;  
    }
    }
}