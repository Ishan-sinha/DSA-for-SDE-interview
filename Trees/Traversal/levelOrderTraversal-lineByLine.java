class Level_Order_Traverse
{
    static void levelOrder(Node node) 
    {
        
         if(node==null)
        return;
        
        Queue<Node> q=new LinkedList<Node>();
        
        q.add(node);
       
      
            while(!q.isEmpty()){
                 int s=q.size();
                 while(s-- != 0)
                {
            
            Node p=q.poll();
            System.out.print(p.data+" ");
            
             if(p.left!=null)
            q.add(p.left);
            if(p.right!=null)
            q.add(p.right);
                
            }
            System.out.println("");
             
           
            }
        }
    }
