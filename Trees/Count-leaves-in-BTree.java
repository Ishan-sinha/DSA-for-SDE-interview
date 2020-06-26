/*
Count Leaves in Binary Tree 

Given a Binary Tree of size N , You have to count leaves in it. For example, there are two leaves in following tree

        1
     /      \
   10      39
  /
5

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denote node values, and a character “N” denotes NULL child.

Output:
For each test case print the count of leaves.
Your Task:
You don't have to take input. Complete the function countLeaves() that takes root node of given tree as parameter and returns the count of leaves in tree . The printing is done by the driver code.
Constraints:
1<= T <= 30
1<= N <= 104 */

class Tree
{
    int countLeaves(Node node) 
    {
         // Your code  
        if(node == null)
            return 0;
        else if(node.left == null && node.right == null)
            return 1;
        else
            return countLeaves(node.left)+countLeaves(node.right);
    }
}