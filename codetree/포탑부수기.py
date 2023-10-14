from collections import deque


N, M, K = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

attack_time = [[0] * M for _ in range(N)]
routee = []
def select_attacker(round):
    global attack_time
    minNum = 1e9

    for i in range(N):
        for j in range(M):
            if board[i][j] != 0:
                minNum = min(minNum, board[i][j])

    p = []
    for i in range(N):
        for j in range(M):
            if board[i][j] == minNum:
                p.append([attack_time[i][j], i + j, j])
    p.sort(reverse=True)
    r, sum_xy, y = p[0]

    nx = sum_xy - y
    ny = y

    board[nx][ny] += (N + M)
    attack_time[nx][ny] = round
    # print(nx,ny)
    # print(N,M)
    return nx, ny


def select_attacked(ax, ay, round):


    global attack_time
    maxNum = -1e9

    for i in range(N):
        for j in range(M):
            # print("i j board[i][j]",i,j,board[i][j])
            if [i, j] != [ax, ay]:  # i!=ax and j!=ay:

                maxNum = max(maxNum, board[i][j])
    # print(maxNum)
    turret = []
    #print(maxNum)
    for i in range(N):
        for j in range(M):
            if maxNum == board[i][j]:
                #print(attack_time[i][j],i+j,j)
                turret.append([attack_time[i][j], i + j, j])

    turret.sort()
    #for qq in range(len(turret)):
        #print(turret[0][0],turret[0][1],turret[0][1]-turret[0][2],turret[0][2])
    r, sum_xy, y = turret[0]

    nx = sum_xy - y
    ny = y
    # nx,ny 는 공격 당하는 포탑
    # ax,ay 는 공격하는 포탑

    #print("공격 당하는 포탑",nx,ny,board[nx][ny])

    #ttack_time[nx][ny] = round

    route = attack(ax, ay, nx, ny)

    return route


def attack(sx, sy, ex, ey):
    sx = sx
    sy = sy
    attack_route = []
    # 레이저 공격

    # 만약 레이저가 성공 안하면 포탑 공격함

    attack_route = laser(sx, sy, ex, ey)

    if len(attack_route) >= 1:
        # print("laser")
        return attack_route
    else:
        # print("bomb")
        attack_route = bomb(sx, sy, ex, ey)
        return attack_route


def laser(sx, sy, ex, ey):
    global board
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    #우/하/좌/상
    q = deque()
    visited = [[False] * M for _ in range(N)]

    q.append((sx, sy, []))
    visited[sx][sy] = True

    laser_route = []
    while q:

        x, y, lst = q.popleft()

        if x == ex and y == ey:
            laser_route = lst

            break

        for i in range(4):
            nx = (x + dx[i] + N) % N
            ny = (y + dy[i] + M) % M
            # if nx >= N:
            #     nx = 0
            # elif nx < 0:
            #     nx = N - 1
            #
            # if ny >= M:
            #     ny = 0
            # elif ny < 0:
            #     ny = M - 1
            if visited[nx][ny]:
                continue

            if board[nx][ny]==0:
                continue

            visited[nx][ny]=True
            q.append((nx,ny,lst+[[nx,ny]]))
            # if visited[nx][ny] is False and board[nx][ny] != 0:
            #     q.append((nx, ny, lst + [[nx, ny]]))
            #     visited[nx][ny] = True

    if len(laser_route) >= 1:
        for x, y in laser_route:

            if x == ex and y == ey:
                board[x][y] -= board[sx][sy]

            else:
                board[x][y] -= (board[sx][sy] // 2)

        return laser_route
    else:
        return []


def bomb(sx, sy, ex, ey):
    bomb_route = []
    board[ex][ey] -= board[sx][sy]
    bomb_route.append([ex, ey])

    #dx = [-1, -1, 0, 1, 1, 1, 0, -1]
    #dy = [0, -1, -1, -1, 0, 1, 1, 1]

    dx = [-1, -1, -1, 0, 1, 1, 1, 0]
    dy = [-1, 0, 1, 1, 1, 0, -1, -1]
    for i in range(8):

        nx = (ex + dx[i]+N)%N
        ny = (ey + dy[i]+M)%M

        # print(")",nx,ny)
        # if nx == N:
        #     nx = 0
        # elif nx < 0:
        #     nx += N
        #
        # if ny == M:
        #     ny = 0
        # elif ny < 0:
        #     ny += M

        if nx == sx and ny==sy:
            continue
        # print(nx,ny)
        if board[nx][ny] >= 1 and [nx, ny] != [sx, sy]:
            bomb_route.append([nx, ny])
            board[nx][ny] -= board[sx][sy] // 2
            #
            # if board[nx][ny] < 0:
            #     board[nx][ny] = 0
    return bomb_route


def broken_turret():
    for i in range(N):
        for j in range(M):
            if board[i][j] <= 0:
                board[i][j] = 0


def fix_turret(r, x, y):
    global board
    # include_attack 공격과관련된 포탑들 넣어줌
    # include_list=[]
    include=list=[]
    include_list = r
    # print(r)
    include_list.append([x, y])
    # print(include_list)
    # 공격과 관련되지 않고, 부서지지 않으면 +1 해줌

    for i in range(N):
        for j in range(M):
            if board[i][j] != 0 and [i, j] not in include_list:
                board[i][j] += 1



for round in range(1,K+1):
    #print(round,"round")
    # for i in board:
    #     print(i)
    # print()
    ax, ay = select_attacker(round)
    #
    # print("작은거에 n+m")
    # for i in board:
    #     print(i)
    # print()
    # print("공격하는 포탑",ax,ay,board[ax][ay])

    # 공격당하는 포탑 선택하고 공격당함
    route = select_attacked(ax, ay, round)
    #print("route",route)
    # 공격받은 포탑이 0보다 작으면 0으로 바꿔줌(부서짐)
    broken_turret()

    # 포탑 정비
    fix_turret(route, ax, ay)

    # for i in board:
    #     print(i)
    # print()
    # print()

    # for i in attack_time:
    #     print(i)
    # print()
    cnt = 0
    for i in range(N):
        for j in range(M):
            if board[i][j] >= 1:
                cnt += 1

    aaaa = -1


            # a = max(aaaa, board[i][j])
    #print(aaaa)
    if cnt == 1:
        break

maxTurret = -1
for i in range(N):
    for j in range(M):
        maxTurret = max(maxTurret, board[i][j])
print(maxTurret)

