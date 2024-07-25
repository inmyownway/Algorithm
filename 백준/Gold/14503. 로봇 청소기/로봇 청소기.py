n,m=map(int,input().split())
r,c,d=map(int,input().split())
graph=[list(map(int,input().split())) for _ in range(n)]

visited=[[0]*m for _ in range(n)]


dx=[-1,0,1,0]
dy=[0,1,0,-1]


visited[r][c]=1



ans=1
while True:


    flag=0

    for _ in range(4):
        nx = r + dx[(d+3)%4]
        ny = c + dy[(d+3)%4]

        d=(d+3)%4

        if 0<=nx<n and 0<=ny<m and graph[nx][ny]==0:
            if visited[nx][ny]==0:
                visited[nx][ny]=1
                ans+=1
                r = nx
                c = ny
                flag=1
                break

    if flag == 0:  # 4방향 모두 청소가 되어 있을 때,
        if graph[r - dx[d]][c - dy[d]] == 1:  # 후진했는데 벽
            print(ans)
            break
        else:
            r, c = r - dx[d], c - dy[d]
