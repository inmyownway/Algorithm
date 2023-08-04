# 2 3 5 9
N=int(input())
ans=0
s=2
for i in range(N):
    s+=s-1

print(s*s)
