from collections import deque
m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
q = deque([])
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
day = 0

for i in range(n):
    for j in range(m):
        if graph[i][j]==1:
            q.append((i,j))
def bfs():
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                q.append([nx, ny])
bfs()
for i in graph:
    for j in i:
        if j==0:
            print(-1)
            exit(0)
    day=max(day,max(i))
print(day-1)
#
# n, m = map(int, input().split())
# graph = []
# for i in range(m):
#     graph.append(list(map(int, input().split())))
#
# dx = [0, 0, -1, 1]
# dy = [1, -1, 0, 0]
# visited = [[False] * n for _ in range(m)]
# day = 0
#
#
# def check():
#     flag=True
#     for i in graph:
#         if 0 in i:
#             flag = False
#     return flag
#
#
# while True:
#     if check():
#         print(day)
#         break
#     if day>n*m:
#         print(-1)
#         break
#     # print('q')
#     q = deque()
#     for i in range(m):
#         for j in range(n):
#             if visited[i][j] == False and graph[i][j] == 1:
#                 visited[i][j]=True
#                 q.append((i, j))
#     while q:
#         #print(q)
#         x, y = q.popleft()
#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]
#
#             if 0 <= nx < m and 0 <= ny < n and visited[nx][ny] == False and graph[nx][ny] == 0:
#                 graph[nx][ny] = 1
#     day += 1
#     # for i in graph:
#     #     print(i)
