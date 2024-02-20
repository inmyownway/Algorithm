from collections import deque
n,m=map(int,input().split())
graph=[]
for i in range(n):
    temp=list(input())
    t=[]
    for j in temp:
        t.append(j)
    graph.append(t)


def bfs():
    global maxCnt
    q = set([(0,0,graph[0][0])])
    while q:
        x,y,z=q.pop()

        maxCnt=max(maxCnt,len(z))
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<= nx < n and 0<= ny < m and graph[nx][ny] not in z:
                q.add((nx,ny,graph[nx][ny]+z))

dx=[0,0,-1,1]
dy=[1,-1,0,0]
maxCnt=1
bfs()


print(maxCnt)






