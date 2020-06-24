/*
Level Order Traversal

In the Level Order Traversal, the binary tree is traversed level-wise starting from the first to last level sequentially.

Algorithm: The Level Order Traversal can be implemented efficiently using a Queue.
Create an empty queue q.
Push the root node of tree to q. That is, q.push(root).
Loop while the queue is not empty:
-Pop the top node from queue and print the node.
-Enqueue node's children (first left then right children) to q
-Repeat the process until queue is not empty.

*/

//Implementation

import java.util.Queue; 
import java.util.LinkedList; 

/* Class to represent Tree node */
class Node { 
    int data; 
    Node left, right; 

    public Node(int item) { 
        data = item; 
        left = null; 
        right = null; 
    } 
} 

/* Class to print Level Order Traversal */
class BinaryTree { 

    Node root; 

    /* Given a binary tree. Print its nodes in  
       level order using array for implementing queue */
    void printLevelOrder() 
    { 
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        while (!queue.isEmpty()) 
        { 
            Node tempNode = queue.poll(); 
            System.out.print(tempNode.data + " "); 

            /* Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
            } 

            /* Enqueue right child */
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
            } 
        } 
    } 

    // Driver Code
    public static void main(String args[]) 
    { 
        // Create the following Binary Tree
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        BinaryTree tree_level = new BinaryTree(); 
        tree_level.root = new Node(1); 
        tree_level.root.left = new Node(2); 
        tree_level.root.right = new Node(3); 
        tree_level.root.left.left = new Node(4); 
        tree_level.root.left.right = new Node(5); 

        System.out.println("Level order traversal " + "of binary tree is - "); 
        tree_level.printLevelOrder(); 
    } 
}
