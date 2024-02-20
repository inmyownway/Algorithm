from collections import deque

m, n, k = map(int, input().split())
# m = 세로
# n= 가로
# m =5 n = 7
# 0,2 -> 0,1
# 4,4 -> 2,3
p = [[0] * n for _ in range(m)]
for i in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            p[i][j] = 1

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]



def bfs(graph, a, b):
    queue = deque()
    queue.append((a, b))
    graph[a][b] = 1
    cnt = 1

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = 1
                queue.append((nx, ny))
                cnt += 1
    return cnt


result = []
for i in range(m):
    for j in range(n):
        if p[i][j] == 0:
            result.append(bfs(p, i, j))

print(len(result))
result.sort()
for rr in result:
    print(rr, end=" ")

#
# for i in range(m):
#     for j in range(n):
#         print(p[i][j],end="")
#     print()
