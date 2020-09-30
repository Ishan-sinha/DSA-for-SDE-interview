from collections import Counter
s = input()
k = input()
d ={}
for c in k:
    d[c] = d.get(c,0)+1
h ={}
# d ={x:1,y:1,z:1}
start=0
for i in range(len(s)):
    h[s[i]] = h.get(s[i],0)+1

    if i>=len(k)-1:
        
        if d==h:
            print('Anagram',s[start:i+1],'present at index',start)
        h[s[start]]-=1
        if h[s[start]]==0:
            del h[s[start]]
        start+=1

# XYYZXZYZXXYZ
# XYZ




