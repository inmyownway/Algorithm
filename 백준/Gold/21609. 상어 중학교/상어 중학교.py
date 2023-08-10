
from collections import deque
# 검은색 블록 -1
# 무지개 블록 0
# 일반블록은 M이라의 자연수로 표현

# 브록 그룹은 일반븐록 하나 있어야함, 모두 같아야함 , 검은색 x
# 무지개는 있어도 상관 X

N,M=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(N)]


def bfs(x,y,num):

    block=[]
    block_cnt=1
    rainbow_cnt=0
    rainbow_block=[]
    q=deque()
    q.append((x,y))
    visited[x][y]=True
    dx=[0,0,-1,1]
    dy=[1,-1,0,0]


    block.append([x,y])
    while q:
        x,y=q.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<N and 0<=ny <N and visited[nx][ny]==False and board[nx][ny]==num:
                visited[nx][ny]=True
                q.append((nx,ny))
                block_cnt+=1
                block.append([nx,ny])
            elif 0<=nx<N and 0<=ny <N and visited[nx][ny]==False and board[nx][ny]==0:
                visited[nx][ny]=True
                q.append((nx, ny))
                block_cnt += 1
                rainbow_cnt+=1
                rainbow_block.append([nx,ny])

    for x,y in rainbow_block:
        visited[x][y]=False

    return [block_cnt,rainbow_cnt,block+rainbow_block]

def remove(lst):
    for x,y in lst:
        board[x][y]=-2
def gravity(board):
    for i in range(N-2,-1,-1):
        for j in range(N):
            if board[i][j]> -1:
                r=i
                while True:
                    if 0<=r+1<N and board[r+1][j]==-2:
                        board[r+1][j]=board[r][j]
                        board[r][j]=-2
                        r+=1
                    else:
                        break

def rotate(board):

    new_board=[[0]* N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            new_board[N-1-j][i]=board[i][j]

    return new_board





score=0
while True:
    blocks = []
    visited = [[False] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if visited[i][j]==False and board[i][j]>0:
                block_info=bfs(i,j,board[i][j])
                if block_info[0]>=2:
                    blocks.append(block_info)
    blocks.sort(reverse=True)
    #print(blocks[0])

    if not blocks:
        break

    remove(blocks[0][2])

    score+=blocks[0][0]**2

    gravity(board)

    board=rotate(board)

    gravity(board)
print(score)



