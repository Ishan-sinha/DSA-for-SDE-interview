/*
Lowest Common Ancestor in a BST 

Given a Binary Search Tree (with all values unique) and two node values. Find the Lowest Common Ancestors of the two nodes in the BST.

Input:
First line of input contains the number of test cases T. For each test case, there will be two line of input. First line is a string representing the tree as described below:

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.
The second line of Input contains two space separated integer values n1 and n2.

Output:
For each testcase, in a new line, print the LCA of n1 and n2.

Your Task:
You don't need to read input or print anything. Your task is to complete the function LCA() which takes the root Node of the BST and two integer values n1 and n2 as inputs and returns the Lowest Common Ancestor of the Nodes with values n1 and n2 in the given BST. 

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST). */

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}



class BST
{   
	 Node LCA(Node node, int n1, int n2)
	{
        // code here.    
        if(node.data<Math.min(n1,n2)){
            return(LCA(node.right,n1,n2));
        }
        else if(node.data>Math.max(n1,n2)){
            return(LCA(node.left,n1,n2));
        }
        else{
            return node;
        }
    }
    
}