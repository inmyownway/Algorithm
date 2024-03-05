from collections import deque
def bfs(i,j):

    q=deque()
    q.append((i,j))
    visited[i][j]=True
    alst=[(i,j)]
    sm=arr[i][j]

    while q:
        x,y=q.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<N and 0<=ny<N:
                if L<=abs(arr[nx][ny]-arr[x][y])<=R:
                    if visited[nx][ny]==0:
                        q.append((nx,ny))
                        visited[nx][ny]=1
                        alst.append((nx,ny))
                        sm+=arr[nx][ny]
    if len(alst)>1:
        for ti,tj in alst:
            arr[ti][tj]=sm//len(alst)
        return 1
    return 0



N, L, R = map(int, input().split())
arr = []
for i in range(N):
    t = list(map(int, input().split()))
    arr.append(t)

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]



ans=0
while ans <=2000:
    visited = [[0] * N for _ in range(N)]
    flag= 0
    for i in range(N):
        for j in range(N):
            if visited[i][j]==0:
                t = bfs(i,j) # bfs는 연합수 리턴
                if t==1:
                    flag=1
    if flag==0:
        # 연합 x , 이동 없음
        break
    ans+=1
print(ans)