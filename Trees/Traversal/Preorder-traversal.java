/*
Preorder Traversal

Given a binary tree, print preorder traversal of it.
For example: preorder traversal of below tree is "1 10 5 39"

        1
     /     \
   10     39
  /
5

Input:
The first line of input contains the number of test cases T. For every test case, the first line of input contains two space-separated integers, denoting node values for which we want to find LCA,  and the second line will contain a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

Output:
The function should print preorder traversal.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function preorder() that takes the root node of the tree as input and returns an array containing the preorder traversal of the tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). */

class BinaryTree
{
    
    static void preorder(Node root)
    {
        // Code here
        if(root==null)
            return;
        else{
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

}