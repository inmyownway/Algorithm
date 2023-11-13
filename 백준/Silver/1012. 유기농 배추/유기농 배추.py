from collections import deque

test_case = int(input())
def bfs(board):

    count=0


    dx=[0,0,-1,1]
    dy=[1,-1,0,0]

    n=len(board)
    m=len(board[0])
    visited=[[False]*m for _ in range(n)]
    #print(n,m)

    for i in range(n):
        for j in range(m):
            #print("@",i,j)
            if visited[i][j]==False and board[i][j]==1:
                count+=1
                q=deque()
                q.append((i,j))

                while q:

                    x,y=q.popleft()

                    for idx in range(4):
                        nx=x+dx[idx]
                        ny=y+dy[idx]
                        if 0<=nx<n and 0<=ny<m:
                            if visited[nx][ny]==False:
                                if board[nx][ny]==1:

                                    q.append((nx,ny))
                                    visited[nx][ny]=True

    return count




for test in range(test_case):
    M,N,K=map(int,input().split())

    board=[[0]*M for _ in range(N)]


    for i in range(K):
        x,y=map(int,input().split())
        #print(x,y)
        board[y][x]=1

    cnt=bfs(board)
    print(cnt)