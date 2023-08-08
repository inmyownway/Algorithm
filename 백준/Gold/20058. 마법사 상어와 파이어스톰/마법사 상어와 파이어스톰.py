from collections import deque

N, Q = map(int, input().split())

ice = [list(map(int, input().split())) for _ in range(2 ** N)]

l = list(map(int, input().split()))
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
len_board = 2 ** N
for idx in l:

    idx = 2 ** idx
    temp = [[0] * (2 ** N) for _ in range(2 ** N)]

    # 세로
    for y in range(0, len_board, idx):
        # 가로
        for x in range(0, len_board, idx):

            for i in range(idx):
                for j in range(idx):
                    temp[y + j][x + idx - 1 - i] = ice[y + i][x + j]

    ice = temp
    # 얼음 줄어들게

    melt=[]
    for i in range(len_board):
        for j in range(len_board):

            near_ice = 0

            for p in range(4):
                nx = i + dx[p]
                ny = j + dy[p]

                if nx < 0 or nx >= len_board or ny < 0 or ny >= len_board:
                    continue
                elif ice[nx][ny] > 0:
                    near_ice += 1
            if near_ice < 3 and ice[i][j] != 0:
                melt.append((i,j))
    for x,y in melt:
        ice[x][y]-=1

visited = [[False] * len_board for _ in range(len_board)]
s = 0
maxCnt = 0



visited=[[False]*len_board for _ in range(len_board)]
ice_sum=0
maxCnt=0


for x in range(len_board):
    for y in range(len_board):
        s+=ice[x][y]
        cnt=0
        if visited[x][y] or ice[x][y]==0:
            continue

        q=deque()
        q.append((x,y))
        visited[x][y]=True

        while q:
            #print("ad")
            sx,sy=q.popleft()

            ice_sum+=ice[sx][sy]
            cnt+=1

            for d in range(4):
                nx=sx+dx[d]
                ny=sy+dy[d]

                if 0<=nx <len_board and 0<= ny<len_board and visited[nx][ny]==False:
                    if ice[nx][ny]>0:
                        visited[nx][ny]=True
                        q.append((nx,ny))
        maxCnt=max(cnt,maxCnt)

print(s)
print(maxCnt)
