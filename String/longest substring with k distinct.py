s = input()
k = int(input())

def rec(k):
    d= {}
    start =0

    res =''
    for i in range(len(s)):
        d[s[i]] = d.get(s[i],0)+1

        while len(d)>k:
            d[s[start]]-=1
            if d[s[start]] ==0:
                del d[s[start]]
            start+=1
        l = i - start+1
        if l > len(res):
            res = s[start:i+1]
    return res

print(rec(k))

