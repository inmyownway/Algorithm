import copy
from collections import  deque
from itertools import combinations
n,m=map(int,input().split())

graph=[]
virus_pos=[]
def bfs(graph,virus):
    q=deque()
    for x,y in virus:
        q.append((x,y,1))
        graph[x][y]=1
    # for i in graph:
    #     print(i)
    # print()

    dx=[0,0,-1,1]
    dy=[1,-1,0,0]
    start_pos=[]
    for i in range(n):
        for j in range(n):
            if graph[i][j]=='*':
                start_pos.append((i,j))
    while q:
        qx,qy,qtime=q.popleft()

        for i in range(4):
            nx=qx+dx[i]
            ny=qy+dy[i]

            if 0<=nx < n and 0<=ny<n:
                if graph[nx][ny]==0:
                    graph[nx][ny]=qtime+1
                    q.append((nx,ny,qtime+1))
                elif graph[nx][ny]=='*':
                    graph[nx][ny]=qtime+1
                    q.append((nx,ny,qtime+1))
                elif graph[nx][ny]!='-' and graph[nx][ny]!=0:
                    graph[nx][ny]=min(graph[nx][ny],qtime+1)
    maxNum=-1e9
    flag=0
    for i in range(n):
        for j in range(n):
            if graph[i][j]==0:
                flag+=1
                return 1e9
    for a,b in start_pos:
        graph[a][b]=0


    for i in range(n):
        for j in range(n):
            if graph[i][j]!='-':
                maxNum=max(maxNum,graph[i][j])
    #print(virus)
    # for i in graph:
    #     print(i)
    # print()

    return maxNum



for i in range(n):
    temp=list(map(int,input().split()))
    graph.append(temp)
    for j in range(len(temp)):
        if graph[i][j]==2:
            virus_pos.append((i,j))

viruses=combinations(virus_pos,m)

maxtime=1e9

for virus in viruses:
    # viurs = 바이러스 m개 들어감
    new_graph=copy.deepcopy(graph)
    for i in range(n):
        for j in range(n):
            if new_graph[i][j]==1:
                new_graph[i][j]='-'
    for x,y in virus:
        #print(x,y)
        new_graph[x][y]='*'

    for i in range(n):
        for j in range(n):
            if new_graph[i][j]==2:
                new_graph[i][j]='*'


    time= bfs(new_graph,virus)
    #print(time)

    maxtime=min(time,maxtime)
if maxtime == 1e9:
    print(-1)
else:
    print(maxtime-1)