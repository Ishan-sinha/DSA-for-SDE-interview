/*
Right View of Binary Tree 
Given a Binary Tree, print Right view of it. 
Right view of a Binary Tree is set of nodes visible when tree is viewed from right side.

Right view of following tree is 1 3 7 8.

          1
       /     \
     2        3
   /   \      /    \
  4     5   6    7
    \
     8

Input :
First line of input contains the number of test cases T. For each test case, there will 
be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree 
where, numbers denotes node values, and a character “N” denotes NULL child.

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output :
For each test case, in a new line, print the right view of the binary tree.

Your Task:
This is a function problem. You don't have to take input. Just complete the function rightView() that 
takes node as parameter and prints the right view. The newline is automatically appended by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree). */

class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}
class Tree{
    void rightView(Node root) {
      if(root==null)
        return;
      Queue<Node> q=new LinkedList<>(); 
      q.add(root);
      while(!q.isEmpty())
      {
          int c=q.size();
          for(int i=0;i<c;i++)
          {
              Node p=q.poll();
              if(i==c-1)
              System.out.print(p.data+" ");
              if(p.left!=null)
                q.add(p.left);
              if(p.right!=null)
                q.add(p.right);
              
          }
      }
    }
}