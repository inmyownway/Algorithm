# 1번 상어가 가장 강함
# 처음에 냄새 뿌림, k번 이동하면 사라짐
# 냄새없는 칸 -> 자신의 냄새 ->

N,M,K=map(int,input().split())

board=[list(map(int,input().split())) for _ in range(N)]


smell=[[[0,0]]*N for _ in range(N)]

dirs=list(map(int,input().split()))
prior = [[] for _ in range(M)]
for i in range(M):
    for j in range(4):
        prior[i].append(list(map(int, input().split())))

dx=[-1,1,0,0]
dy=[0,0,-1,1]


def update_smell1():
    for i in range(N):
        for j in range(N):
            if smell[i][j][1]>0:
                smell[i][j][1]-=1
            if board[i][j]!=0:
                smell[i][j]=[board[i][j],K]

def update_smell():
    # 각 위치를 하나씩 확인하며
    for i in range(N):
        for j in range(N):
            # 냄새가 존재하는 경우, 시간을 1만큼 감소시키기
            if smell[i][j][1] > 0:
                smell[i][j][1] -= 1
            # 상어가 존재하는 해당 위치의 냄새를 k로 설정
            if board[i][j] != 0:
                smell[i][j] = [board[i][j], K]

def move():
    new_board=[[0]*N for _ in range(N)]

    for x in range(N):
        for y in range(N):
            # 상어 존재시
            if board[x][y]!=0:
                dir = dirs[board[x][y]-1]
                found=False

                for i in range(4):
                    nx=x+dx[prior[board[x][y]-1][dir-1][i]-1]
                    ny=y+dy[prior[board[x][y]-1][dir-1][i]-1]

                    if 0<=nx<N and 0<=ny<N:
                        if smell[nx][ny][1]==0: # 냄새 존재 x

                            dirs[board[x][y]-1]=prior[board[x][y]-1][dir-1][i]

                            # 이미 상어 있다면 낮은 상어 들어가도록
                            if new_board[nx][ny]==0:
                                new_board[nx][ny]=board[x][y]
                            else:
                                new_board[nx][ny]=min(new_board[nx][ny],board[x][y])
                            found =True
                            break
                if found:
                    continue

                for i in range(4):
                    nx = x + dx[prior[board[x][y] - 1][dir - 1][i] - 1]
                    ny = y + dy[prior[board[x][y] - 1][dir - 1][i] - 1]

                    if 0 <= nx < N and 0 <= ny < N:
                        if smell[nx][ny][0] == board[x][y]:  # 냄새가 자기 냄새인경우

                            dirs[board[x][y]-1]=prior[board[x][y]-1][dir-1][i]


                            new_board[nx][ny]=board[x][y]
                            break
    return new_board
time=0


while True:
    update_smell()
    new_board=move()

    board=new_board


    time += 1

    check = True
    for i in range(N):
        for j in range(N):
            if board[i][j] > 1:
                check = False

    if check:
        print(time)
        break

    # 1,000초가 지날 때까지 끝나지 않았다면
    if time >= 1000:
        print(-1)
        break





