/*
Given a linked list of N nodes. The task is to check if the the linked list 
has a loop. Linked list can contain self loop.

Input:
First line of input contains number of testcases T. For each testcase, first
 line of input contains length of linked list and next line contains the data 
of linked list. Third line contains an integer denoting the position of the 
linked list node(counting from head) to which the last node connects in order
 to create a loop. If this integer is 0, this means no loop exists.

Output:
For each testcase, print "True", if linked list contains loop, else print "False".
*/

class Solution {
    public int detectLoop(Node head) {
        
        HashSet <Node> s=new HashSet();
while(head!=null)
{
if(s.contains(head))
return 1;
s.add(head);

head=head.next;
}
return 0;
    }
}