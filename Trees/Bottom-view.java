/*
Bottom View of Binary Tree 

Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.

Input Format:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 

Output Format:
The function should print nodes in the bottom view of Binary Tree. Your code should not print a newline, it is added by the caller code that runs your function.

Your Task:
This is a functional problem, you don't need to care about input, just complete the function bottomView() which takes the root node of the tree as input and returns an array containing the bottom view of the given tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). */

class Node
{
    int data; 
    int hd; 
    Node left, right; 

    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
 }


class Tree
{
 
    // Method that prints the bottom view.
    public void bottomView(Node root)
    {
    if (root == null) {
         return;
    }
 
      int hd = 0;
      Map<Integer, Integer> map = new TreeMap<>();
      Queue<Node> queue = new LinkedList<>();
      root.hd = hd;
      queue.add(root);
 
      while (!queue.isEmpty()) {
         Node temp = queue.remove();
         hd = temp.hd;
         map.put(hd, temp.data);
         if (temp.left != null) {
            temp.left.hd = hd - 1;
            queue.add(temp.left);
         }
         if (temp.right != null) {
            temp.right.hd = hd + 1;
            queue.add(temp.right);
         }
      }
      Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
      while (iterator.hasNext()) {
         Map.Entry<Integer, Integer> me = iterator.next();
         System.out.print(me.getValue() + " ");
      }
    
    }
}