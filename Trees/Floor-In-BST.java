/*

Given a Binary search tree and a value X,  the task is to complete
 the function which will return the floor of x.

Note: Floor(X) is an element that is either equal to X or immediately 
smaller to X. If no such element exits return -1.

*/


class Sol
{
    int floor(Node root, int key) 
    { 
        Node res=null;
        while(root!=null)
        {
          
            if(root.data==key)
            return root.data;
            else if(root.data>key)
            root=root.left;
            else
            {
                res=root;
                root=root.right;                
            }
      }
        if(res!=null)
        return res.data;
        else
        return -1;
 } 
 
}