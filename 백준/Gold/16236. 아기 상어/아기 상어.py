import quopri
from collections import deque
n=int(input())
l=[]
x,y,size=0,0,2
for i in range(n):
    temp=list(map(int,input().split()))
    l.append(temp)
    for j in range(len(temp)):
        if l[i][j]==9:
            x = i
            y = j

dx=[0,0,-1,1]
dy=[1,-1,0,0]
cnt=0
#print(x,y)

def bitefish(x,y,shark_size):
    distance=[[0]* n for _ in range(n)]
    visited=[[0]*n for _ in range(n)]
    q=deque()
    q.append((x,y))
    #print(x,y)
    visited[x][y]=1
    temp=[]
    while q:
        cx,cy=q.popleft()
        for i in range(4):
            nx=cx+dx[i]
            ny=cy+dy[i]
            if 0<= nx < n and 0<= ny < n and visited[nx][ny]==0:
                if l[nx][ny]<=shark_size:
                    q.append((nx,ny))
                    visited[nx][ny]=1
                    distance[nx][ny]=distance[cx][cy]+1
                    if l[nx][ny]< shark_size and l[nx][ny]!=0:
                        temp.append((nx,ny,distance[nx][ny]))

    return sorted(temp,key=lambda x: (-x[2],-x[0],-x[1]))

result = 0
while True:
    shark=bitefish(x,y,size)

    if len(shark)==0:
        break
    ax,ay,dist=shark.pop()

    result+=dist
    l[x][y],l[ax][ay]=0,0

    x,y=ax,ay
    cnt+=1
    if cnt==size:
        size+=1
        cnt=0

print(result)