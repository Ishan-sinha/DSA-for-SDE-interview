/*
Write a function to print Boundary Traversal of a binary tree. 
Boundary Traversal of a binary tree here means that you have to 
print boundary nodes of the binary tree Anti-Clockwise starting
from the root.
Note: Boundary node means nodes present at the boundary of left 
subtree and nodes present at the right subtree also including leaf nodes.
For the below tree, the function should print 20 8 4 10 14 25 22 .

https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

*/


class Solution
{
	ArrayList <Integer> printBoundary(Node node)
	{
	     ArrayList<Integer> a=new ArrayList<>();
	     if(node==null)
	    return a;
	  
	    a.add(Integer.valueOf(node.data));
	    left(node.left,a);
	    leaves(node.left,a);
	    leaves(node.right,a);
	    right(node.right,a);
	   
	    return a;
	    
	}
	void left(Node root,ArrayList<Integer> a)
	{
	    if(root==null)
	    return;
	    if(root.left!=null)
	    {
	     a.add(root.data);
	     left(root.left,a);
	    }
	    else if(root.right!=null)
	    {
	         a.add(root.data);
	    left(root.right,a);
	    }
	}
	void right(Node root,ArrayList<Integer> a)
	{
	   
	   
	    if(root==null)
	    return;
	    if(root.right!=null)
	    {
	        right(root.right,a);
	     a.add(root.data);
	     
	    }
	    else if(root.left!=null)
	    {
	        right(root.left,a);
	         a.add(root.data);
	    
	    }
	}
	void leaves(Node root,ArrayList<Integer> a)
	{
	    if(root==null)
	        return;
	        leaves(root.left,a);
	   if(root.left==null&&root.right==null){
	       a.add(Integer.valueOf(root.data));
	      // return;
	   }
	   
	   leaves(root.right,a);
	}
}
