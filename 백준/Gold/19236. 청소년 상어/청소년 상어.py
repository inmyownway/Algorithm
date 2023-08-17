# # 각 물고기는 번호와 방향을 가짐
# # 번호 (1~16) , 방향은 8가지
# # 0,0 물고기를 먹고 들어감
#
# board=[[0]*4 for _ in range(4)]
# dir=[[0]*4 for _ in range(4)]
#
# for j in range(4):
#     l=list(map(int,input().split()))
#     idx=0
#     for i in range(0,len(l),2):
#         a,b=l[i],l[i+1]
#
#         board[j][idx]=a
#         dir[j][idx]=b-1
#         idx+=1
#
# sx,sy=0,0
#
# dx=[-1,-1,0,1,1,1,0,-1]
# dy=[0,-1,-1,-1,0,1,1,1]
#
# def fish_move():
#
#     for i in range(1,17):
#
#         for x in range(4):
#             for y in range(4):
#                 if board[x][y]==i:
#                     print(i,x,y,dir[x][y])
#
#                     d=dir[x][y]
#
#                     cnt=0
#                     # 1 2 3 4 5 6 7 8
#                     for j in range(d,d+8):
#                         j=j%8
#                         #print(nx,ny)
#                         nx=x+dx[j]
#                         ny=y+dy[j]
#                         if 0<=nx<4 and 0<=ny<4:
#                             print(nx,ny,j)
#                             if board[nx][ny]!=-1:
#                                 if board[nx][ny]==0:
#                                     board[nx][ny]=i
#                                     dir[nx][ny]=dir[x][y]
#                                     #print(nx,ny,j)
#                                     break
#                                 elif board[nx][ny]>=1:
#
#                                     temp_num=board[nx][ny]
#                                     temp_dir=dir[nx][ny]
#
#                                     board[nx][ny]=i
#                                     dir[nx][ny]=j
#
#                                     board[x][y]=temp_num
#                                     dir[x][y]=temp_dir
#                                     #print(nx,ny,j)
#                                     break
#
#                     # for i in board:
#                     #     print(i)
#                     # print()
#                     #
#                     # for i in dir:
#                     #     print(i)
#                     # print()
#
# def sharK_move():
#     for x in range(4):
#         for y in range(4):
#             if board[x][y]==-1:
#                 print()
#
#
#
#
#
#
#

import copy

board = [[] for _ in range(4)]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]

for i in range(4):
    data = list(map(int, input().split()))
    fish = []
    for j in range(4):
        # 물고기 번호, 방향
        fish.append([data[2*j], data[2*j+1]-1])
    board[i] = fish

max_score = 0



def dfs(sx, sy, score, board):
    global max_score

    score += board[sx][sy][0]

    max_score = max(score, max_score)
    board[sx][sy][0] = 0
    # fish move
    for ff in range(1, 17):
        f_x, f_y = -1, -1
        for x in range(4):
            for y in range(4):
                if board[x][y][0] == ff:
                    f_x, f_y = x, y
                    break
        if f_x == -1 and f_y == -1:
            continue

        fish_dir = board[f_x][f_y][1]

        for i in range(8):
            nd = (fish_dir + i) % 8
            nx = f_x + dx[nd]
            ny = f_y + dy[nd]

            if not (0 <= nx < 4 and 0 <= ny < 4) or (nx == sx and ny == sy):
                continue

            board[f_x][f_y][1] = nd
            board[f_x][f_y], board[nx][ny] = board[nx][ny], board[f_x][f_y]
            break
    # shark move
    s_d = board[sx][sy][1]
    for i in range(1, 5):
        nx = sx + dx[s_d] * i
        ny = sy + dy[s_d] * i
        if (0 <= nx < 4 and 0 <= ny < 4) and board[nx][ny][0] > 0:
            dfs(nx, ny, score, copy.deepcopy(board))


dfs(0, 0, 0, board)
print(max_score)
