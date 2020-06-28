/*
Given a binary tree of size N, you have to count number of nodes in it. For example, count of nodes in below tree is 4.

        1
     /      \
   10      39
  /
5

*/

class Tree
{
	public static int getSize(Node root)
	{

if(root==null)
return 0;
return 1+getSize(root.left)+getSize(root.right);
    }
}