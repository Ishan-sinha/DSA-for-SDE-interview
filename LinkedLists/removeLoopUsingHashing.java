/*
Detect and Remove Loop using Hashing
*/
class solver
{
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Set<Node> set=new HashSet();
Node temp=head;
while(temp!=null){
if(set.contains(temp.next)){
temp.next=null;
return;
}
set.add(temp);
temp=temp.next;
}
return;

    }
}