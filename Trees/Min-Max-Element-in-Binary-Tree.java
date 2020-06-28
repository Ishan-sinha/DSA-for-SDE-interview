/*

Given a Binary Tree, find maximum and minimum elements in it.

*/

class main
{
	public static int findMax(Node root)
	{
	    
	    int max=Integer.MIN_VALUE;
	    if(root==null)
	    return max;
	    return Math.max(root.data,Math.max(findMax(root.left),findMax(root.right)));
	}
	public static int findMin(Node root)
	{
	    
	    int min=Integer.MAX_VALUE;
	    if(root==null)
	    return min;
	    return Math.min(root.data,Math.min(findMin(root.left),findMin(root.right)));
	}
}