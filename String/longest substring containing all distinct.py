s = input()
d ={}
start =0
res =''
for i in range(len(s)):
    d[s[i]] = d.get(s[i],0)+1
    while d[s[i]]>1:
        d[s[start]]-=1
        start+=1
    l = i-start+1
    if l> len(res):
        res = s[start:i+1]
print(res)

# abbcdafeegh

