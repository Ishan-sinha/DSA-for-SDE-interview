'''
Given an unsorted array arr[] of size N and that contains even number of occurrences for
all numbers except two numbers. Find the two numbers in decreasing order which have odd
occurrences.

Note: Expected O(n) time complexity and O(1) extra space.

Example:
Input:
2
8
4 2 4 5 2 3 3 1
6
1 7 5 5 4 4

Output:
5 1
7 1

'''

for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    xor=0
    r1=0
    r2=0
    for i in range(n):
        xor=xor^a[i]
    sn=xor&~(xor-1)
    for j in range(n):
        if((a[j]&sn)!=0):
            r1=r1^a[j]
        else:
            r2=r2^a[j]
    if(r1>r2):
        print(r1,r2)
    else:
        print(r2,r1)