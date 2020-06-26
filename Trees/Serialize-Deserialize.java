/*
Serialize and Deserialize a Binary Tree 

Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading
 tree back from the array. Now your task is to complete the function serialize which stores the tree into an 
 array A[ ] and deSerialize which deserializes the array to tree and returns it.

Note: The structure of tree must be maintained.

Input:
First line of input contains the number of test cases T. For each test case, there will be 
only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, 
numbers denotes node values, and a character “N” denotes NULL child.

Output:
The output in the expected output will be the inorder traversal of the returned tree.

Your Task:
The task is to complete two function serialize which takes the root node of the tree as input andstores the tree into an array and deSerialize which deserializes the array to the original tree and returns the root of it.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). */

class Tree{
	int data;
	Tree left,right;
	Tree(int d){
		data=d;
		left=right=null;
	}
}

class Tree {
	public void serialize(Node root, ArrayList<Integer> A) {
	    if(root == null){
	        A.add(-1);
	        return;
	    }
	    A.add(root.data);
	    serialize(root.left,A);
	    serialize(root.right,A);
	    
	}
	
	int index = 0;
    public Node deSerialize(ArrayList<Integer> A){
        if(index==A.size() || A.get(index)==-1){
            index += 1;
            return null;
        }
        Node node = new Node(A.get(index));
        index += 1;
        node.left=deSerialize(A);
        node.right = deSerialize(A);
        return node;
    }
}

