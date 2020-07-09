'''
Check whether K-th bit is set or not
Given a number n, check if k-th bit of n is set or not.

Examples:

Input : n = 5, k = 1
Output : SET
5 is represented as 101 in binary
and has its first bit set.

Input : n = 2, k = 3
Output : NOT SET
2 is represented as 10 in binary, 
all higher i.e. beyond MSB,
bits are NOT SET.
'''

for _ in range(int(input())):
    n,m= map(int,input().split())
    if n & (1 << (k - 1)): 
        print( "SET") 
    else: 
        print("NOT SET") 
    