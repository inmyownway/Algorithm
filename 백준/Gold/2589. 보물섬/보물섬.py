from collections import deque

N,M=map(int,input().split())

def bfs(idx):

    q=deque()
    x,y=idx
    q.append(idx)
    dx=[0,0,-1,1]
    dy=[1,-1,0,0]
    visted=[[0]*M for _ in range(N)]
    visted[x][y]=1
    while q:
        x,y=q.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<N and 0<=ny<M:
                if visted[nx][ny]==0 and board[nx][ny]=='L':
                    visted[nx][ny]=visted[x][y]+1
                    q.append((nx,ny))

    maxCnt=-1e9
    for i in range(N):
        for j in range(M):
            maxCnt=max(maxCnt,visted[i][j])

    return maxCnt;





board=[]
for _ in range(N):
    temp=list(input())
    board.append(temp)

answer=-1e9
for i in range(N):
    for j in range(M):
        if board[i][j]=='L':
            #print(i,j)
            #print(bfs((i,j)))
            answer= max(answer,bfs((i,j)))

print(answer-1)