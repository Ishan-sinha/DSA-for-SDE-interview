/*

Huffman Decoding-1 

The task is to implement Huffman Encoding and Decoding.

Input:
First line consists of T test cases. Only line of every test case consists of String S.

Output:
Single line output, return the Decoded String.

Constraints:
1<=T<=100
2<=S<=1000  */


import java.io.*;
import java.util.*;
import java.lang.*;

class minHeapNode {
    char data;
    int freq;
    minHeapNode left, right;
    minHeapNode(char data, int freq){
        left = right = null;
        this.data = data;
        this.freq = freq;
    }
}

class heapComparator implements Comparator<minHeapNode> {
    public int compare(minHeapNode h1, minHeapNode h2) { 
        if (h1.freq < h2.freq) {
            return 1;
        } else if (h1.freq > h2.freq) {
            return -1;
        }
        return 0; 
    } 
} 

class driverClass {
    
    static PriorityQueue<minHeapNode> heapq;
    static HashMap<Character, Integer> freqMap;
    static HashMap<Character, String> codes;
    
    static void storeCodes(minHeapNode root, String str) {
        if(root==null)return;
        if(root.data != '$')codes.put(root.data, str);
        storeCodes(root.left, str + "0");
        storeCodes(root.right, str + "1");
    }
    
    static void encodeString(){
        minHeapNode left, right, top;
        for (Map.Entry<Character, Integer> val:freqMap.entrySet()) {
            heapq.add(new minHeapNode(val.getKey(), val.getValue()));
        }
        while (heapq.size() != 1) {
            left = heapq.poll();
            right = heapq.poll();
            top = new minHeapNode('$', left.freq + right.freq);
            top.left = left;
            top.right = right;
            heapq.add(top);
        }
        storeCodes(heapq.peek(), "");
    }
    
    static void calcFreq(String str) {
        for (int i=0; i<str.length(); i++) { 
            Integer j = freqMap.get(str.charAt(i)); 
            freqMap.put(str.charAt(i), (j == null) ? 1 : j + 1); 
        } 
    }
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String str = br.readLine().trim();
            heapq = new PriorityQueue<minHeapNode>(new heapComparator());
            codes = new HashMap<Character, String>();
            freqMap = new HashMap<Character, Integer>();
            String encodedString = "";
            calcFreq(str);
            encodeString();
            for(int i=0; i<str.length(); i++){
                encodedString+=codes.get(str.charAt(i));
            }
            GfG g = new GfG();
            System.out.println(g.decodeString(heapq.peek(), encodedString));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class GfG {
    // your required to complete this function
    // this function should return the encoded string
    // see the main function for the minHeapNode reference
    String decodeString(minHeapNode root, String encodedStr){
        String ans="";
        minHeapNode temp=root;
        for(int i=0;i<encodedStr.length();i++){ 
            if(encodedStr.charAt(i)=='0') 
                temp=temp.left; 
            else 
                temp=temp.right;
            if(temp.left==null && temp.right==null){
                ans+=temp.data; 
                temp=root;
            }
        }
        return ans;
    }
}

