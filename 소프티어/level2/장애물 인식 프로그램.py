import sys
from collections import deque

graph = []
N = int(input())
for i in range(N):
    temp = list(input())
    graph.append(temp)

cnt = []

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
visited = [[False] * N for _ in range(N)]
#print(graph)
for i in range(N):
    for j in range(N):
        if graph[i][j]=='1' and visited[i][j] == False:
            #print(i,j)
            q = deque()
            q.append((i, j))
            temp_count = 1
            visited[i][j] = True

            while q:
                #print(q)
                x, y = q.popleft()
                #visited[x][y]=True

                for idx in range(4):
                    nx = x + dx[idx]
                    ny = y + dy[idx]

                    if 0 <= nx < N and 0 <= ny < N:
                        if graph[nx][ny] == '1' and visited[nx][ny]==False:
                            temp_count += 1
                            visited[nx][ny] = True
                            q.append((nx, ny))
            cnt.append(temp_count)
cnt.sort()
print(len(cnt))
#print(cnt)
for i in range(len(cnt)):
    print(cnt[i])




