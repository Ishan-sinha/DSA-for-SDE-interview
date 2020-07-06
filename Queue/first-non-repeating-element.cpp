/*
First non-repeating character in a stream 

Given an input stream of N characters consisting only of lower case alphabets. 
The task is to find the first non repeating character, each time a character 
is inserted to the stream. If no non repeating element is found print -1.

Input:
The first line of input contains an integer T denoting the no of test cases. 
Then T test cases follow. Each test case contains an integer N denoting the size 
of the stream. Then in the next line are x characters which are inserted to the stream.

Output:
For each test case in a new line print the first non repeating elements separated by 
spaces present in the stream at every instinct when a character is added to the stream, 
if no such element is present print -1.

Constraints:
1 <= T <= 200
1 <= N <= 500

Example:
Input:
2
4
a a b c
3
a a c

Output:
a -1 b b
a -1 c

Explanation:
Test Case 1: a a b c
The step wise first non-repeating elements are made bold:
a (print a)
a a (no non-repeating element, print -1)
a a b (print b)
a a b c (print b)
Result: a -1 b b

Test Case 2: a a c
a (print a)
a a (no non-repeating element, print -1)
a a c (print c)
Result: a -1 c                          */

#include <bits/stdc++.h>
using namespace std;

int main() {

    int t;
    cin>>t;
    while(t--){
        
        int n;
        cin>>n;
        
        vector<char> ch(n);
        
        for(int i=0;i<n;i++){
            cin>>ch[i];
        }
        
        int freq[26];
        
        for(int i=0;i<26;i++){
            
            freq[i]=0;
        }
        
        queue<char> q;
        
        for(int i=0;i<n;i++){
            
            // Increase frequency of current element
            freq[ch[i]-'a']++;
            
            // Push it into the queue
            q.push(ch[i]);
            
            while(!q.empty()){
                
                // Try element in front of the queue
                
                // If it's frequency>1 it can't be non repeating pop it out and try next one
                if(freq[q.front()-'a']>1){
                    q.pop();
                }
                // Freq=1 so print and break
                else{
                    cout<<q.front()<<" ";
                    break;
                }
                
            }
            // Can't find any non repeating character
            if(q.empty()){
                cout<<-1<<" ";
            }
            
        }
        cout<<endl;
    }
	
}