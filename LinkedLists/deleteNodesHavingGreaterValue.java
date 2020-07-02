/*
Given a singly linked list, remove all the nodes which have a greater value on its next adjacent element.
Example:
Input:
3
8
12 15 10 11 5 6 2 3
6
10 20 30 40 50 60
6
60 50 40 30 20 10

Output:
15 11 6 3
60
60 50 40 30 20 10
*/

class main
{
    Node compute(Node head)
    {
        if(head.next==null)
return head;
Node temp=compute(head.next);
if(temp.data > head.data)
return temp;
else
head.next=temp;
return head;
    }
}
  