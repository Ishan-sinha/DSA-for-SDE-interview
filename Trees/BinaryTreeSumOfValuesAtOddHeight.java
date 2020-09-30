/*
For problem and solution description please visit the link below
http://www.dsalgo.com/2013/03/binary-tree-sum-of-nodes-at-odd-levels.html
*/

package com.dsalgo;
public class BinaryTreeSumOfValuesAtOddHeight
{
 public static void main(String[] args)
 {
  Node a = new Node(1);
  Node b = new Node(2);
  Node c = new Node(3);
  Node d = new Node(4);
  Node e = new Node(5);
  Node f = new Node(8);
  Node g = new Node(6);
  Node h = new Node(9);
  a.left = b;
  a.right = c;
  b.left = d;
  b.right = e;
  c.right = f;
  f.left = g;
  f.right = h;
  int sum = findOddLevelSum(a);
  System.out.println(sum);
 }

 private static int findOddLevelSum(Node a)
 {
  return findOddLevelSum(a, true);
 }

 private static int findOddLevelSum(Node a, boolean oddLevel)
 {
  if (a == null)
   return 0;
  int childSum=findOddLevelSum(a.left, !oddLevel)
    + findOddLevelSum(a.right, !oddLevel);
  if (oddLevel)
   return a.value + childSum;
  else
   return childSum;
 }

 static class Node
 {
  Node left;
  Node right;
  int value;

  public Node(int value)
  {
   this.value = value;
  }
 }

}

