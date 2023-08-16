# # 손님 도착지로 데려다 줄떄 연록 충전
# # 연료 0 일시 종료
# # M명 태우는게 목표  , 최단경로로 움직임
# from collections import deque
#
# # 현재위치에서 최단거리가 가장 짧은 승객을 고름
#
# N,M,fuel= map(int,input().split())
#
# board=[list(map(int,input().split())) for _ in range(N)]
#
# sx,sy=map(int,input().split())
# sx-=1
# sy-=1
# p=[]
# for _ in range(M):
#     px,py,ddx,ddy=map(int,input().split())
#     p.append([px-1,py-1,ddx-1,ddy-1])
# dx=[0,0,-1,1]
# dy=[1,-1,0,0]
# def find_shortest_way(sx,sy):
#
#     temp_lst=[]
#     way=[]
#
#     for i in range(len(p)):
#         way.append(abs(p[i][0]-sx)+abs(p[i][1]-sy))
#     #print(way)
#     minWay=1e9
#
#     for i in range(len(p)):
#         minWay=min(minWay,way[i])
#
#
#
#     way=[]
#     for j in range(len(p)):
#
#         q=deque()
#         q.append((sx,sy,0))
#         visited=[[False]*N for _ in range(N)]
#         visited[sx][sy]=True
#
#         while q:
#
#             x,y,d=q.popleft()
#             if x==p[j][0] and y==p[j][1]:
#                 way.append([x,y,d])
#             for i in range(4):
#                 nx=x+dx[i]
#                 ny=y+dy[i]
#
#                 if 0<=nx<N and 0<=ny<N:
#                     if visited[nx][ny]==False and board[nx][ny]==0:
#                         q.append((nx,ny,d+1))
#                         visited[nx][ny]=True
#     #print(way)
#
#
#     way.sort(key=lambda x:(-x[2],-x[0],-x[1]))
#     #print(way[-1])
#
#     if len(way)==0:
#         return 0
#     return way[-1]
#
# def move(sx,sy,end_x,end_y):
#     q=deque()
#     q.append((sx,sy,0))
#
#     visited=[[False]*N for _ in range(N)]
#
#     while q:
#
#         x, y,d = q.popleft()
#         if x==end_x and y==end_y:
#             return d
#
#
#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]
#
#             if 0 <= nx < N and 0 <= ny < N:
#                 if visited[nx][ny] == False and board[nx][ny] == 0:
#                     q.append((nx, ny, d + 1))
#                     visited[nx][ny] = True
#     return -1
#
# while True:
#     if fuel<=0 or len(p)==0:
#         print(fuel)
#         break
#
#     passenger=find_shortest_way(sx,sy)
#     #print(passenger)
#     if passenger==0:
#         print(-1)
#         break
#
#     start_x,start_y,d=passenger[0],passenger[1],passenger[2]
#
#
#     for i in range(len(p)):
#         if start_x==p[i][0] and start_y==p[i][1]:
#             #print(p[i][0],p[i][1])
#             end_x=p[i][2]
#             end_y=p[i][3]
#             del p[i]
#             break
#
#
#     fuel-=d
#     #print("d",d,fuel)
#     if fuel<=0:
#         print(-1)
#         break
#
#
#     sx,sy=start_x,start_y
#
#     move_fuel=move(sx,sy,end_x,end_y)
#     if move_fuel==-1:
#         print(-1)
#         break
#     #print(move_fuel)
#
#     fuel-=move_fuel
#
#     if fuel<0:
#         print(-1)
#         break
#     else:
#         fuel+=move_fuel*2
#         sx,sy=end_x,end_y
#
#
#
#
#  시간초과

from collections import deque

N,M,fuel=map(int,input().split())
board=[list(map(int,input().split())) for _ in range(N)]
tx,ty=map(int,input().split())
taxi=[tx-1,ty-1]

start=[]
end=[]
for _ in range(M):
    sx,sy,ex,ey=map(int,input().split())
    start.append([sx-1,sy-1])
    end.append([ex-1,ey-1])

dx=[0,0,-1,1]
dy=[1,-1,0,0]
def findPassenger(taxi):
    q=deque()
    q.append(taxi)
    visited=[[0]*N for _ in range(N)]
    minDistance=1e9

    shortest_passenger=[]
    while q:
        x,y=q.popleft()
        if visited[x][y]>minDistance:
            break
        if [x,y] in start:
            minDistance=visited[x][y]
            shortest_passenger.append([x,y])
        else:
            for i in range(4):
                nx=x+dx[i]
                ny=y+dy[i]

                if 0 <= ny < N and 0 <= nx < N and board[nx][ny] != 1 and visited[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append([nx, ny])

    if shortest_passenger:
        shortest_passenger.sort()
        return visited[shortest_passenger[0][0]][shortest_passenger[0][1]],shortest_passenger[0][0],shortest_passenger[0][1]
    else:
        return -1,-1,-1


def move(start,end):
    q=deque()
    q.append(start)

    visited=[[0]*N for _ in range(N)]
    while q:
        x,y=q.popleft()
        if [x,y] ==end:
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= ny < N and 0 <= nx < N and board[nx][ny] != 1 and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                q.append([nx, ny])
    return visited[x][y],x,y




for z in range(M):
    distance,px,py=findPassenger(taxi)
    #print(px,py,distance)
    if distance==-1 or fuel-distance<0:
        fuel=-1
        break

    fuel-=distance

    idx = start.index([px,py])
    #print(idx)
    start[idx]=[-1,-1]

    distance2,end_x,end_y=move([px,py],end[idx])

    if [end_x,end_y]!=end[idx] or fuel-distance2<0:
        fuel=-1
        break
    fuel-=distance2
    fuel+=distance2*2
    taxi=[end_x,end_y]

print(fuel)






