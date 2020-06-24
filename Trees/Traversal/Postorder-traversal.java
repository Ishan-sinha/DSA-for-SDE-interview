/*
Postorder Traversal

Given a binary tree, find the Postorder Traversal of it.
For Example, the postorder traversal of the following tree is:  5 10 39 1

        1
     /     \
   10     39
  /
5

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

Output:
For each test case, in a new line, print the postorder traversal.

Your Task:
You don't need to read input or print anything. Your task is to complete the function postOrder() that takes root node as input and returns an array containing the postorder traversal of the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). */

class Tree
{
    void postOrder(Node root)
    {
       // Your code goes here
       if(root == null)
            return;
       postOrder(root.left);
       postOrder(root.right);
       System.out.print(root.data+" ");
    }
}