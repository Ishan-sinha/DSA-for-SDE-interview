arr = list(map(int,input().split()))
k = int(input())
start=0
s= set()
f= False
for i in range(len(arr)):
    
    if i>=k:
        if arr[i] in s:
            print('Duplicate found')
            f = True
            break
        s.remove(arr[start])
        start+=1
    s.add(arr[i])
if not f:
    print('Not found')

