test_case = int(input())

for test in range(1, test_case + 1):
    N, M = map(int, input().split())

    board = [[0] * N for _ in range(N)]

    board[(N // 2) - 1][(N // 2) - 1] = 2
    board[(N // 2) - 1][(N // 2)] = 1
    board[(N // 2)][(N // 2) - 1] = 1
    board[(N // 2)][(N // 2)] = 2

    #

    for i in range(M):
        # print(i)
        x, y, color = map(int, input().split())
        x -= 1
        y -= 1
        #print(x,y,color)
        if color == 1:
            board[x][y] = 1
        elif color == 2:
            board[x][y] = 2

        dx = [0, 0, -1, 1, -1, -1, 1, 1]
        dy = [-1, 1, 0, 0, -1, 1, -1, 1]

        for d in range(8):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < N and 0 <= ny < N and board[x][y] != board[nx][ny] and board[nx][ny]!=0:

                l = [(nx, ny)]
                flag = False
                while True:

                    nx += dx[d]
                    ny += dy[d]
                    if 0 <= nx < N and 0 <= ny < N:
                        if board[nx][ny] == 0:
                            break

                        if board[nx][ny] != board[x][y] and board[x][y]!=0:
                            l.append((nx, ny))

                        elif board[nx][ny] == board[x][y]:
                            flag = True
                            break


                    else:
                        break
                if flag:

                    for a, b in l:
                        board[a][b] = board[x][y]
                # elif flag==False:
                #     board[x][y]=0
                # for ia in board:
                #     print(ia)
                # print()

    black = 0
    white = 0
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j] == 2:
                white += 1
            elif board[i][j] == 1:
                black += 1

    print("#%d %d %d" % (test, black, white))
