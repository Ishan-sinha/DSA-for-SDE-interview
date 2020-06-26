/*
Check for Balanced Tree 

Given a binary tree, find if it is height balanced or not. 
A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 

A height balanced tree
        1
     /     \
   10      39
  /
5

An unbalanced tree
        1
     /    
   10   
  /
5

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 
The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

Output:
For each testcase, in a new line, print 0 or 1 accordingly.

Your Task:
You don't need to take input. Just complete the function isBalanced() that takes root node as parameter and returns true, if the tree is balanced else returns false.

Constraints:
1 <= T <= 100
1 <= Number of nodes <= 105
0 <= Data of a node <= 106

Expected time complexity: O(N)
Expected auxiliary space: O(h) , where h = height of tree*/

class Tree
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced(Node root)
    {
	// Your code here
	if(root==null){
	    return true;
	}
	    int lh = height(root.left);
	    int rh = height(root.right);
	    if(Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right)){
	        return true;
	    }
        return false;
    }
    static int height(Node node){
        if(node == null){
            return 0;
        }
        else{
            int lheight = height(node.left);
            int rheight = height(node.right);
            return 1+Math.max(lheight,rheight);
        }
    }
}
