s=list(map(int,input().split()))
k=int(input())

d={}
start=0
for i in range(len(s)):
    d[s[i]]=d.get(s[i],0)+1
    
    if i>=k-1:
        print('The count of distinct element in sub-array',[start,i],len(d))
        d[s[start]]-=1
        if d[s[start]]==0:
            del d[s[start]]
        start+=1

# 2 1 2 3 2 1 4 5
# 5    
