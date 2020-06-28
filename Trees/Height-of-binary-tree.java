class Tree
{
    int height(Node node) 
    {
        
         if(node==null)
         return 0;
         int l=height(node.left);
         int r=height(node.right);
         return 1+Math.max(l,r);
    }   
}