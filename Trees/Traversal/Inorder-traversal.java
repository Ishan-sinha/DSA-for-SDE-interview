/*

In Order Traversal

Given a Binary Tree, find the In-Order Traversal of it.

Input:
First line of input contains the number of test cases T. For each test case, there will be 
only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree 
where, numbers denotes node values, and a character “N” denotes NULL child.

Output:
For each test case, in a new line, print the inorder traversal.

Your Task:
You don't need to read input or print anything. Your task is to complete the function inOrder() that takes root node of the tree as input and returns a list containing the In-Order Traversal of the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). */

class Tree
{
 
    void inOrder(Node root)
    {
        // Code
        if(root == null)
            return;
        else{
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
       
}