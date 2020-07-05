/*

LRU Cache 

The task is to design and implement methods of an LRU cache. 
The class has two methods get() and set() which are defined as follows.
get(x)   : Returns the value of the key x if the key exists in the cache otherwise returns -1.
set(x,y) : inserts the value if the key x is not already present. If the cache reaches its 
capacity it should invalidate the least recently used item before inserting the new item.
In the constructor of the class the size of the cache should be intitialized.

Input:
The first line of input contain an integer T denoting the number of test cases. Then T test 
case follow. Each test case contains 3 lines. The first line of input contains an integer N 
denoting the capacity of the cache and then in the next line is an integer Q denoting the 
number of queries Then Q queries follow. A Query can be of two types
1. SET x y : sets the value of the key x with value y
2. GET x : gets the key of x if present else returns -1.

Output:
For each test case, in a new line, output will be space separated values of the query.

Your Task:
This is a function problem. You only need to complete the provided functions get() and set(). 

Expected Time Complexity: O(1) for both get() and set().
Expected Auxiliary Space: O(1) for both get() and set(). (though, you may use extra space for cache storage and implementation purposes).

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= Q <= 100000
1 <= x, y <= 1000

Example:
Input:
2
2
2
SET 1 2 GET 1
2
7
SET 1 2 SET 2 3 SET 1 5 SET 4 5 SET 6 7 GET 4 GET 1
Output:
2
5 -1

Explanation: 
Test Case 1: Cache Size = 2
SET 1 2 GET 1
SET 1 2 : 1 -> 2
GET 1 : Print the value corresponding to Key 1, ie 2.
Test Case 2: Cache Size = 2
SET 1 2 SET 2 3 SET 1 5 SET 4 5 SET 6 7 GET 4 GET 1
SET 1 2 : 1 -> 2
SET 2 3 : 1 -> 2, 2 -> 3 (the most recently used one is kept at the rightmost position) 
SET 1 5 : 2 -> 3, 1 -> 5
SET 4 5 : 1 -> 5, 4 -> 5 (Cache size is 2, hence we delete the least recently used key-value pair)
SET 6 7 : 4 -> 5, 6 -> 7 
GET 4 : Prints 5
GET 1 : No key-value pair having key = 1. Hence prints -1. */

import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Node
{
    int key, value;
    Node next, pre;

    Node(int key, int value)
    {
        this.key = key;
        this.value = value;
        next = pre = null;
    }
}

// design the class in the most optimal way
class LRUCache
{
    private static Map<Integer, Node> hsMap;
    private static int capacity, count;
    private static Node head, tail;

    LRUCache(int cap)
    {
        hsMap=new HashMap<>();
        this.capacity=cap;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        head.pre=null;
        tail.next=null;
        tail.pre=head;
        count=0;
    }
    
    public static void addToHead(Node node){
        node.next=head.next;
        node.next.pre=node;
        node.pre=head;
        head.next=node;
    }
    
    public static void deleteNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    // This method works in O(1)
    public static int get(int key)
    {
        if(hsMap.get(key)!=null){
            Node node = hsMap.get(key);
            int result=node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    // This method works in O(1)
    public static void set(int key, int value)
    {
        if (hsMap.get(key) != null) {
            Node node = hsMap.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            Node node = new Node(key, value);
            hsMap.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            }
            else {
                hsMap.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}
