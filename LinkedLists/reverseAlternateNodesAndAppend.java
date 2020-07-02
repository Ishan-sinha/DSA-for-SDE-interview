/*
Given a linked list, you have to perform the following task:

Extract the alternative nodes from starting from second node.
Reverse the extracted list.
Append the extracted list at the end of the original list.

Input:
2
8
10 4 9 1 3 5 9 4
5
1 2 3 4 5

Output:
10 9 3 9 4 5 1 4
1 3 5 4 2 

*/

class main
{
    public static void rearrange(Node odd)
    {
        Node temp=odd,ppre=null,pre=null,nxt;
    int cnt=1;
    while(temp!=null)
    {
        nxt=temp.next;
        if(cnt%2!=0 && ppre!=null)
            ppre.next=temp;
        else if(cnt%2==0)
            temp.next=ppre;
        ppre=pre;
        pre=temp;
        temp=nxt;
        cnt++;
    }
    if(cnt%2!=0)
    ppre.next=pre;
    else
    pre.next=ppre;
    }
}