/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/02/LinkedListRandomPointer.php.html
*/

package com.dsalgo;

import java.util.HashMap;
import java.util.Map;


public class LinkedListRandomPointer
{

 public static void main(String[] args)
 {
  NodeRandom a=new NodeRandom(4);
  NodeRandom b=new NodeRandom(5);
  NodeRandom c=new NodeRandom(3);
  NodeRandom d=new NodeRandom(6);
  NodeRandom e=new NodeRandom(7);
  NodeRandom f=new NodeRandom(2);
  NodeRandom g=new NodeRandom(9);
  NodeRandom h=new NodeRandom(3);
  NodeRandom i=new NodeRandom(7);
  a.next=b;
  b.next=c;
  c.next=d;
  d.next=e;
  e.next=f;
  f.next=g;
  g.next=h;
  h.next=i;
  a.random=g;
  b.random=a;
  c.random=e;
  d.random=f;
  e.random=e;
  f.random=null;
  g.random=b;
  h.random=i;
  i.random=f;
  printLinkedList(a);
  printLinkedList(deepCopy(a));
  
 }
 private static void printLinkedList(NodeRandom head)
 {
  while(head!=null)
  {
   System.out.print(head);
   head=head.next;
  }
  System.out.println();
 }
 public static NodeRandom deepCopy(NodeRandom sourceHead)
 {
  Map<NodeRandom,NodeRandom> map=new HashMap<NodeRandom, NodeRandom>();
  NodeRandom sourcePtr=sourceHead;
  NodeRandom destHead=null;
  NodeRandom destPtr=null;
  while(sourcePtr!=null)
  {
   if(destHead==null)
   {
    destHead=new NodeRandom(sourcePtr.value);
    destPtr=destHead;
   }
   else
   {
    destPtr.next=new NodeRandom(sourcePtr.value);
    destPtr=destPtr.next;
   }
   map.put(sourcePtr, destPtr);
   sourcePtr=sourcePtr.next;
  }
  sourcePtr=sourceHead;
  destPtr=destHead;
  while(sourcePtr!=null)
  {
   destPtr.random=map.get(sourcePtr.random);
   sourcePtr=sourcePtr.next;
   destPtr=destPtr.next;
  }
  return destHead;
 }

 static class NodeRandom
 {
  public NodeRandom next;
  public NodeRandom random;
  public int value;
  public NodeRandom(int value)
  {
   this.value=value;
  }
  public String toString()
  {
   if(random==null)
    return "{"+hashCode()+"("+value+") r->null}";
   else
    return "{"+hashCode()+"("+value+") r->"+random.hashCode()+"}";
  }
 }
}
  
