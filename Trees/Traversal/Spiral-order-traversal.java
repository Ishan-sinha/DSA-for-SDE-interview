/*
Level order traversal in spiral form 

Complete the function to print spiral order traversal of a tree. For below tree, function should print 1, 2, 3, 4, 5, 6, 7.

Input:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

Output:
The function should print level order traversal in spiral form.

Your Task:
The task is to complete the function printSpiral() which prints the elements in spiral form of level order traversal. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). */

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Spiral
{
      Stack<Node> s1 = new Stack<Node>();
      Stack<Node> s2 = new Stack<Node>();
      void printSpiral(Node node) 
      {
           // Your code here
           if(node==null)
            return;
           s2.push(node);
           while(s1.empty()==false || s2.empty()==false)
           {
               while(s2.empty() == false){
                   Node p = s2.pop();
                   System.out.print(p.data +" ");
                   if(p.right != null)
                        s1.push(p.right);
                   if(p.left != null)
                        s1.push(p.left);
               }
               while(s1.empty() == false){
                   Node p = s1.pop();
                   System.out.print(p.data +" ");
                   if(p.left != null)
                        s2.push(p.left);
                   if(p.right != null)
                        s2.push(p.right);
               }
           }
      }
}