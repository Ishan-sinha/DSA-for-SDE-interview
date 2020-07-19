/*

Given a BST and an integer. Find the least absolute difference between 
any node value of the BST and the given integer.

*/


class Solution
{
    
    static int maxDiff(Node  root, int K) 
    { 
        
        int res = Integer.MAX_VALUE;
while(root != null){
if(root.data == K)
return 0;

if(root.data > K)
root = root.left;

res = Math.min(Math.abs(root.data - K) , res);

if(root.data < K)
root = root.right;
}
return res;
        
        
    } 
}