/*

Merge Sort for Linked List


Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of nodes in the linked list and next line contains N elements of the linked list.

Output:
For each test, in a new line, print the sorted linked list.

Your Task:
For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(1) */

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new LinkedList().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



class LinkedList
{
    static Node mergeSort(Node head)
    {
        if(head==null || head.next==null) return head;
Node mid= partition(head);
return merge(mergeSort(head),mergeSort(mid));
}
static Node partition(Node head){
Node fast=head.next;
Node slow=head;
while(fast!=null){
fast=fast.next;
if(fast!=null){
fast=fast.next;
slow=slow.next;
}
}
Node second=slow.next;
slow.next=null;
return second;
}
static Node merge(Node head,Node second){
if(head==null) return second;
if(second==null) return head;
Node c=null;
if(head.data<=second.data) c=head;
else{
c=second;
second=head;
head=c;
}
while(head.next!=null){
if(head.next.data>second.data){
Node temp=head.next;
head.next=second;
second=temp;
}
head=head.next;
}
head.next=second;
return c;
}
}

