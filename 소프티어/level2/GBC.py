import sys

# 0~ 50 , 50~ 90 , 90~100
# 50m/s   40m/s  ,  10m/s
# 0~60 76m/s
# 60~78 28m/s
# 78~100 50m/s
N,M=map(int,input().split())
b=[0 for _ in range(101)]
test=[0 for _ in range(101)]

n_sum=1
m_sum=1
for i in range(N):
    w,s=map(int,input().split())
    start=n_sum
    n_sum+=w
    for j in range(start,n_sum):
        b[j]=s
for i in range(M):
    w,s=map(int,input().split())
    start=m_sum
    m_sum+=w
    for j in range(start,m_sum):
        test[j]=s

#print(b)
maxNum=-1
for i in range(1,101):
    if test[i]-b[i]>=1:
        maxNum=max(maxNum,test[i]-b[i])
if maxNum==-1:
    print(0)
else:
    print(maxNum)



