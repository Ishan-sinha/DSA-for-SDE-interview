/*

Merge Sort on Doubly Linked List 

Given Pointer/Reference to the head of a doubly linked list of N nodes, the task is to Sort 
the given doubly linked list using Merge Sort in both non-decreasing and non-increasing order.

Input:
There are be multiple test cases, for each test case function mergeSort() will be called separately. 
The only input to the function is the pointer/reference to the head of the doubly linked list.

Output:
For each test, print the sorted doubly linked list in both order i.e. in non-decreasing and non-increasing order.

Your Task:
The task is to complete the function sortDoubly() which sorts the doubly linked list. The printing 
is done automatically by the driver code.

Constraints:
1 <= T <= 100
1 <= N <= 105 */


import java.util.*;
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next, prev;
    Node(int key)
    {
        data = key;
        next = prev = null;
    }
}

class Driverclass
{
    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        int a1 = sc.nextInt();
	        Node head = new Node(a1);
	        Node temp = head;
	        
	        for (int i = 1;i < n;i++)
	        {
	            int a = sc.nextInt();
	            Node n1 = new Node(a);
	            n1.prev = temp;
	            temp.next = n1;
	            temp = n1;
	        }
	        
	        head = new LinkedList().sortDoubly(head);
	        printList(head);
	    }
	}
	public static void printList(Node node)
	{
	    Node temp = node;
	    while(node != null)
	    {
	        System.out.print(node.data + " ");
	        temp = node;
	        node = node.next;
	    }
	    System.out.println();
	    while(temp != null)
	    {
	        System.out.print(temp.data + " ");
	        temp = temp.prev;
	    }
	    System.out.println();
	}
}


class LinkedList
{
static Node sortDoubly(Node head)
{
if(head==null||head.next==null)
return head;
Node middle=getMiddle(head);
Node nextOfMiddle = middle.next;
middle.next=null;
Node left = sortDoubly(head);
Node right = sortDoubly(nextOfMiddle);
Node sortedList = sortedMerge(left,right);
return sortedList;
}

public static Node getMiddle(Node head){
if(head==null)
return head;
Node slow=head,fast=head;
while(fast.next!=null&&fast.next.next!=null){
slow=slow.next;
fast=fast.next.next;
}
return slow;

}

public static Node sortedMerge(Node a,Node b){
Node result=null;
if(a==null)
return b;
if(b==null)
return a;
if(a.data<=b.data){
result=a;
a=a.next;
}else{
    result=b;
b=b.next;
}
result.prev=null;
Node curr=result;
while(a!=null&&b!=null){

if(a.data<=b.data){
a.prev=curr;
curr.next=a;
a=a.next;
}else{
b.prev=curr;
curr.next=b;
b=b.next;
}
curr=curr.next;

}
if(a==null){
b.prev=curr;
curr.next=b;
}
if(b==null){
a.prev=curr;
curr.next=a;
}
return result;
}
}