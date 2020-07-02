public static int isBalancedCheck(Node root)
{
    if(root == null)
    {
        return 0;
    }
    
    int lh = isBalancedCheck(root.left);
    if(lh == -1)
    {
        return -1;
    }
    
    int rh = isBalancedCheck(root.right);
    if(rh == -1)
    {
        return -1;
    }
    
    if(Math.abs(lh-rh) > 1)
    {
        return -1;
    }
    else
    {
        return 1 + Math.max(lh, rh);
    }
}
    boolean isBalanced(Node root)
    {
	// Your code here
    if(isBalancedCheck(root) == -1)
    {
        return false;
    }
    return true;