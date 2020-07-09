'''
Find the Number Occurring Odd Number of Times
Given an array of positive integers. All numbers occur even number of 
times except one number which occurs odd number of times. 
Examples :

Input : arr = {1, 2, 3, 2, 3, 1, 3}
Output : 3

Input : arr = {5, 7, 2, 7, 5, 2, 5}
Output : 5
The Best Solution is to do bitwise XOR of all the elements. XOR of all
elements gives us odd occurring element. Please note that XOR of two 
elements is 0 if both elements are same and XOR of a number x with 0 is x.

'''

for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    res=0
    for i in range(n):
        res=res^a[i]
    print(res)
        