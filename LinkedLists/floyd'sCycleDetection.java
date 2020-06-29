/*
Using Floyd's Cycle Detection
*/class Solution {
    public static boolean detectLoop(Node head){
        // Add code here
        Node f=head;
        Node s=head;
        if(head==null)
        return false;
        while(f!=null && f.next!=null)
        {
            f=f.next.next;
            s=s.next;
            if(f==s)
            return true;
        }
        return false;
    }
}