n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
x, y = n // 2, n // 2
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]


windx = [
    # left
    [-1, 1, -2, 2, 0, -1, 1, -1, 1],
    # down
    [-1, -1, 0, 0, 2, 0, 0, 1, 1],
    # right
    [1, -1, 2, -2, 0, 1, -1, 1, -1],
    # up
    [1, 1, 0, 0, -2, 0, 0, -1, -1]
]
windy = [
    # left
    [1, 1, 0, 0, -2, 0, 0, -1, -1],
    # down
    [-1, 1, -2, 2, 0, -1, 1, -1, 1],
    # right
    [-1, -1, 0, 0, 2, 0, 0, 1, 1],
    # up
    [1, -1, 2, -2, 0, 1, -1, 1, -1]
]


rate = [1, 1, 2, 2, 5, 7, 7, 10, 10]

# left -> down -> right -> up





def wind(x, y, dir):
    value = 0
    sand = data[x][y]

    sum_value = 0

    for i in range(9):
        nx = x + windx[dir][i]
        ny = y + windy[dir][i]

        wind_sand = (sand * rate[i]) // 100
        sum_value += wind_sand

        if not (0 <= nx < n and 0 <= ny < n):
            value += wind_sand
            continue
        data[nx][ny] += wind_sand

    nx = x + dx[dir]
    ny = y + dy[dir]
    a = sand - sum_value

    if not (0 <= nx < n and 0 <= ny < n):
        value += a
    else:
        data[nx][ny] += a

    data[x][y] = 0
    # print(value)
    return value


def solve(x, y):
    s = 0
    dir_cnt = 0

    dir = 0

    while True:
        if x == 0 and y == 0:
            break

        if dir == 0 or dir == 2:
            dir_cnt += 1

        for i in range(dir_cnt):
            x = x + dx[dir]
            y = y + dy[dir]
            #print(x, y)

            s += wind(x, y, dir)


            if x == 0 and y == 0:
                break
        dir += 1
        dir = dir % 4
    return s



answer = solve(x, y)
print(answer)
