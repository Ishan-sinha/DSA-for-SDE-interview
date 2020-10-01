for _ in range(int(input())):
    n=int(input())
    x=input()
    a=list(x)
    #r=a.reverse()
    #print(a)
    j=n-1
    
    b=[]
    b.append(0)
    z=[]
    o=[]
    for i in range(n):
        if(a[i]=='0'):
            z.append(a[i])
        else:
            break
    #a.reverse()
    while(j>=0):
        
        if(a[j]=='1'):
            o.append(a[j])
        else:
            break
        j=j-1
    #print(z)
    #print(o)
    c=z+o
    y=[]
    y.extend(z)
    y.extend(b)
    y.extend(o)
    if(len(c)!=n):
        print("".join(map(str, y)))
    else:
        print("".join(map(str, c)))
        