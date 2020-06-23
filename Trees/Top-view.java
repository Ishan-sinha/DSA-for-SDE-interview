/* Top view of a Binary Tree

Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)

A node x is there in output if x is the topmost node at its horizontal distance. Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6 */

// Java program to print top view of binary tree 
import java.util.Queue; 
import java.util.TreeMap; 
import java.util.LinkedList; 
import java.util.Map; 
import java.util.Map.Entry; 

// class to create a node 
class Node { 
	int data; 
	Node left, right; 

	public Node(int data) { 
		this.data = data; 
		left = right = null; 
	} 
} 

// class of binary tree 
class BinaryTree { 
	Node root; 

	public BinaryTree() { 
		root = null; 
	} 
	
	// function should print the topView of 
	// the binary tree 
	private void TopView(Node root) { 
		class QueueObj { 
			Node node; 
			int hd; 

			QueueObj(Node node, int hd) { 
				this.node = node; 
				this.hd = hd; 
			} 
		} 
		Queue<QueueObj> q = new LinkedList<QueueObj>(); 
		Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>(); 

		if (root == null) { 
			return; 
		} else { 
			q.add(new QueueObj(root, 0)); 
		} 

		System.out.println("The top view of the tree is : "); 
		
		// count function returns 1 if the container 
		// contains an element whose key is equivalent 
		// to hd, or returns zero otherwise. 
		while (!q.isEmpty()) { 
			QueueObj tmpNode = q.poll(); 
			if (!topViewMap.containsKey(tmpNode.hd)) { 
				topViewMap.put(tmpNode.hd, tmpNode.node); 
			} 

			if (tmpNode.node.left != null) { 
				q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1)); 
			} 
			if (tmpNode.node.right != null) { 
				q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1)); 
			} 

		} 
		for (Entry<Integer, Node> entry : topViewMap.entrySet()) { 
			System.out.print(entry.getValue().data); 
		} 
	} 
	
	// Driver Program to test above functions 
	public static void main(String[] args) 
	{ 
		/* Create following Binary Tree 
			1 
		/ \ 
		2 3 
		\ 
			4 
			\ 
			5 
			\ 
				6*/
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.right = new Node(4); 
		tree.root.left.right.right = new Node(5); 
		tree.root.left.right.right.right = new Node(6); 
		System.out.println("Following are nodes in top view of Binary Tree"); 
		tree.TopView(tree.root); 
	} 
	
} 
