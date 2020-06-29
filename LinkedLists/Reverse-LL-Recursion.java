class ReverseLL
{
    // This function should reverse linked list and return
    // head of the modified linked list.
    Node reverseList(Node head)
    {
        
        if (head == null || head.next == null)  
            return head;  
  
        
        Node newHead = reverseList(head.next);  
        head.next.next = head;  
  
        
        head.next = null;  
  
    
        return newHead;  
    }
}