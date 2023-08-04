import sys

test_case = int(input())

num = {}

#  0
# 1 2
#  3
# 4 5
#  6
num[0] = [1, 1, 1, 0, 1, 1, 1]

num[1] = [0, 0, 1, 0, 0, 1, 0]

num[2] = [1, 0, 1, 1, 1, 0, 1]

num[3] = [1, 0, 1, 1, 0, 1, 1]

num[4] = [0, 1, 1, 1, 0, 1, 0]

num[5] = [1, 1, 0, 1, 0, 1, 1]

num[6] = [1, 1, 0, 1, 1, 1, 1]

num[7] = [1, 1, 1, 0, 0, 1, 0]

num[8] = [1, 1, 1, 1, 1, 1, 1]

num[9] = [1, 1, 1, 1, 0, 1, 1]

for _ in range(test_case):

    nx = []
    ny = []
    xlst = []
    ylst = []
    x, y = input().split()
    print(x, y)
    if len(x) <= 4:
        for i in range(5 - len(x)):
            xlst.append(0)
            nx.append([0, 0, 0, 0, 0, 0, 0])

    if len(y) <= 4:
        for i in range(5 - len(y)):
            ylst.append(0)
            ny.append([0, 0, 0, 0, 0, 0, 0])

    for j in range(len(x)):
        xlst.append(int(x[j]))
        nx.append(num[int(x[j])])

    for j in range(len(y)):
        ylst.append(int(y[j]))
        ny.append(num[int(y[j])])

    cnt = 0
    print(nx)
    for p in range(5):

        px = nx[i]
        py = ny[i]

        print(px)
        print(py)

        for i in range(7):
            if py[i] == 1 and px[i] == 0:
                cnt += 1
            elif py[i] == 0 and px[i] == 1:
                cnt += 1
        print(cnt)
    print(cnt)