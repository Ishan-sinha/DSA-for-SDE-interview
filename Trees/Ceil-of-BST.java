/*

Given an array arr[] of N positive integers to be inserted into 
BST and a number X. The task it to find Ceil of X.
Note: Ceil(X) is a number that is either equal to X or is immediately
greater than X.

*/

class main
{
    int findCeil(Node root, int key) { 
        if (root == null)
            return -1;
int res=-1;
while(root!=null){
if(root.data==key)
return root.data;
else if(root.data>key){
res=root.data;
root=root.left;
}
else
root=root.right;
}
return res;
    } 
}

