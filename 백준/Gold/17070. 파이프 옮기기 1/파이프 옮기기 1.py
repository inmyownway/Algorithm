
from collections import deque

graph=[]
n=int(input())

for i in range(n):
    temp=list(map(int,input().split()))
    graph.append(temp)

h=0
v=1
d=2
cnt=0

def dfs(fx,fy,ex,ey,type):
    global cnt
    if fx == n-1 and fy == n-1:
        cnt+=1
        return

    if type== h or type == d:
        if fy+1 < n and graph[fx][fy+1]==0:
            dfs(fx,fy+1,fx,fy,h)
    if type == v or type == d:
        if fx+1 < n and graph[fx+1][fy]==0:
            dfs(fx+1,fy,fx,fy,v)

    if fx+1 < n and fy+1<n:
        if graph[fx][fy+1]==0 and graph[fx+1][fy]==0 and graph[fx+1][fy+1]==0:
            dfs(fx+1,fy+1,fx,fy,d)

dfs(0,1,0,0,h)
print(cnt)
# start=(0,1,0,0)
#
#
# g=[(0,1),(1,1)]
# s=[(1,0),(1,1)]
# d=[(0,1),(1,0),(1,1)]
#
# q=deque()
# q.append((0,1,0,0))
# cnt=0
# print(graph)
# while q:
#     print(q)
#     fx,fy,ex,ey= q.popleft()
#     if fx == n-1 and fy == n-1:
#         cnt+=1
#         continue
#
#
#     if fx==ex and fy!=ey: #가로
#         if fy +1 <n and graph[fx][fy+1]==0:
#             q.append((fx,fy+1,fx,fy))
#         if fy+1 <n and fx+1 < n and graph[fx+1][fy+1]==0:
#             q.append((fx+1,fy+1,fx,fy))
#
#     elif fx!=ex and fy==ey: #세로 인경우
#         if fx +1 <n and graph[fx+1][fy]==0:
#             q.append((fx+1,fy,fx,fy))
#         if fy+1 <n and fx+1 < n and graph[fx+1][fy+1]==0:
#             q.append((fx+1,fy+1,fx,fy))
#     elif fx!= ex and fy!=ey:
#         if fx +1 <n and graph[fx+1][fy]==0:
#             q.append((fx+1,fy,fx,fy))
#         if fy+1 <n and fx+1 < n and graph[fx+1][fy+1]==0:
#             q.append((fx+1,fy+1,fx,fy))
#         if fy+1<n and graph[fx][fy+1]==0:
#             q.append((fx,fy+1,fx,fy))
#     #print(q)
# print(cnt)
#
#
#
