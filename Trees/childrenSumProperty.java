/*
Given a Binary Tree. Check whether all of its nodes have the value equal
 to the sum of their child nodes.

Input:
First line of input contains the number of test cases T. For each test case, 
there will be only a single line of input which is a string representing the
 tree as described below: 

The values in the string are in the order of level order traversal of the tree
where, numbers denotes node values, and a character “N” denotes NULL child.

For example:

 
For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
Return 1 if the given tree satisfies the given property else return 0.
*/

class Tree
{
    // Return 1 if all the nodes in the tree satisfy the given property. Else return 0
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root==null)
        return 1;
        if(root.left==null && root.right==null)
        return 1;
        int sum=0;
        if(root.left!=null)
        sum=sum+root.left.data;
        if(root.right!=null)
        sum=sum+root.right.data;
        if(root.data==sum && isSumProperty(root.left)==1 && isSumProperty(root.right)==1)
        return 1;
        else
        return 0;
        
    }
}