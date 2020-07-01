class Tree
{
    // /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(Node root)
    {
        // Your code here
        if(root==null)
        return 0;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        int r=0;
        while(!q.isEmpty())
        {
            int c=q.size();
            r=Math.max(r,c);
            while(c-- > 0)
            {
                Node curr=q.poll();
                if(curr.left!=null)
                q.add(curr.left);
                if(curr.right!=null)
                q.add(curr.right);
            }
        }
        return r;
        
    }		
}
