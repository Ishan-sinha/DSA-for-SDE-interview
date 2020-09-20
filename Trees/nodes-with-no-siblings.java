/*
Given a Binary Tree of size N, find all the nodes which don't have any sibling. Root node can not have a sibling.

Example 1:

Input :
       37
      /   
    20
    /     
  113 

Output: 20 113
Explanation: 20 and 113 dont have any siblings.

Example 2:

Input :
       1
      / \
     2   3 

Output: -1
Explanation: Every node has a sibling. */


import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

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

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
    	        g.printSibling(root);
    	        System.out.println();
	        }
	}
}

//User function Template for Java

class Tree
{
	void printSibling(Node node)
	{
		ArrayList<Integer> list = new ArrayList<>();
		if(node==null)
		{
		    return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while(q.size() != 0)
		{
		    int count=q.size();
		    for(int i=0;i<count;i++)
		    {
		        Node temp = q.poll();
		        if(temp.right==null && temp.left==null)
		            continue;
		        if(temp.right==null && temp.left !=null)
		            list.add(temp.left.data);
		        if(temp.left==null && temp.right !=null)
		            list.add(temp.right.data);
		        if(temp.left != null)
		            q.add(temp.left);
		        if(temp.right!=null)
		            q.add(temp.right);
		    }
		}
		if(list.size()==0)
		    System.out.print(-1);
		else{
		    Collections.sort(list);
		    for(int k:list){
		        System.out.print(k+" ");
		    }
		}
	}
}