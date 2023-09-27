import copy
from collections import deque

n,m=map(int,input().split())

board=[list(map(int,input().split())) for _ in range(n)]





q=deque()
q.append((n-2,0))
q.append((n-2,1))
q.append((n-1,0))
q.append((n-1,1))


def move():
    global board
    temp = deque()

    dx = [0,0, -1, -1, -1, 0, 1, 1, 1]
    dy = [0,1, 1, 0, -1, -1, -1, 0, 1]

    while q:
        x, y = q.popleft()

        nx = (x + dx[d]*p) % n
        ny = (y + dy[d]*p) % n
        board[nx][ny]+=1
        temp.append((nx, ny))

    #print(temp)
    return temp

def grow(move_cloud):

    dx=[-1,-1,1,1]
    dy=[-1,1,-1,1]



    for x,y in move_cloud:



        cnt=0
        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<n and 0<=ny<n:
                if board[nx][ny]>=1:
                    board[nx][ny]+=1
        board[x][y]+=cnt

def re():
    new_cloud=deque()

    for i in range(n):
        for j in range(n):
            if (i,j) not in move_cloud and board[i][j]>=2:
                board[i][j]-=2
                new_cloud.append((i,j))

    return new_cloud

for _ in range(m):
    d,p=map(int,input().split())



    move_cloud=move()


    grow(move_cloud)


    q=re()




answer=0

for i in range(n):
    for j in range(n):
        answer+=board[i][j]
print(answer)

