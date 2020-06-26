/* 
Vertical Traversal of Binary Tree 

Given a Binary Tree, print the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Input Format:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

Output Format:
For each testcase, the vertical order traversal of the tree is to be printed. The nodes' data are to be separated by spaces.

Your Task:
You don't need to read input or print anything. Your task is to complete the function verticalOrder() which takes the root node as input and returns an array containing the vertical order traversal of the tree from the leftmost to the rightmost level. If 2 nodes lie in the same vertical level, they should be printed in the order they appear in the level order traversal of the tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). */

class Pair{
    int level;
    Node node;
    Pair(int level,Node node){
        this.level = level;
        this.node = node;
    }
    
    Node getNode(){
        return this.node;
    }
    
    int getLevel(){
        return this.level;
    }
}

class BinaryTree
{
    static void verticalOrder(Node root)
    {
        TreeMap<Integer,List<Integer>> tmap = new TreeMap<Integer,List<Integer>>();
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0,root));
        
        while(!q.isEmpty()){
            int n = q.size();
            while(n-- > 0){
                Pair p = q.poll();
                
                Node node = p.getNode();
                int level = p.getLevel();
                
                if(tmap.containsKey(level)){
                    tmap.get(level).add(node.data);
                }else{
                    List<Integer> li = new LinkedList<Integer>();
                    li.add(node.data);
                    tmap.put(level,li);
                }
                
                if(node.left != null){
                    q.add(new Pair(level-1,node.left));
                }
                if(node.right != null){
                    q.add(new Pair(level+1,node.right));
                }
            }
        }
        
        for(Map.Entry e : tmap.entrySet()){
            List list = (List)e.getValue();
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
        }
    }    
}