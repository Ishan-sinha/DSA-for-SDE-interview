/*
Additive sequence 

Given a string, the task is to find whether it contains an additive sequence or not. A string contains an additive sequence if its digits 
can make a sequence of numbers in which every number is addition of previous two numbers. You are required to complete the function which 
returns true if the string is a valid sequence else returns false.

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow . Each test case contains a string s.

Output:
For each test case in a new line output will be 1 if it contains an additive sequence and 0 if it doesn't contains an additive sequence.

Constraints:
1<=T<=100
1<=length of string<=200 */

bool additive(string a, int last, int current,int last2)
{
    int len = a.size();
    if(len==0 && current==3)
        return true;
    if(len==0)
        return false;
    bool op = false;
    if(current==1)
    {
        for(int i=1;i<a.size();i++)
        {
            stringstream s(a.substr(0,i));
            int n;
            s>>n;
            op = op || additive(a.substr(i,len-i),n,2,last2);
        }
        return op;
    }
    if(current==2)
    {
        bool op= false;
        for(int i=1;i<a.size();i++)
        {
            stringstream s(a.substr(0,i));
            int n;
            s>>n;
            int temp = last + n;
            op = op || additive(a.substr(i,len-i),temp,3,n);
        }
        return op;
    }
    if(current==3)
    {
        bool op = false;
        for(int i=1;i<=a.size();i++)
        {
            stringstream s(a.substr(0,i));
            int n;
            s>>n;
            if(n==last)
            {
                int temp = last2 + n;
                op = op || additive(a.substr(i,len-i),temp,3,n);
            }
        }
        return op;
    }
}
bool isAdditiveSequence(string n)
{
    //Your code here
    return additive(n,0,1,0);
}