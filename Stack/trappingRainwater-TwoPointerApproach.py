#code
for _ in range(int(input())):
    n=int(input())
    height=list(map(int,input().split()))
    left=0
        
    right=n-1
    left_max=0
    right_max=0
    res=0
    while(left<right):
        if(height[left]<height[right]):
            if(height[left]>left_max):
                left_max=height[left]
            else:
                res+=left_max-height[left]
            left+=1
        else:
            if(height[right]>right_max):
                right_max=height[right]
            else:
                res+=right_max-height[right]
            right-=1
    print(res)