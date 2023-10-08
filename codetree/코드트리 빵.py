from collections import deque

# 1번 사람은 1분에
# 2번 사람은 2분에 베이스캠프에서 출발

# 1단계
# 격자에 잇는 사람들이 편의점을 향해 1칸 움직임( 최소거리로)

# 2단계
# 편의점 도착하면 멈추고, 다른사람은 여기 못지나감

# 편의점과 가장 가까이있는 베이스 캠프 들어감


# 5 3
# 0 0 0 0 0 (1은베이스캠프)
# 1 0 0 0 1
# 0 0 0 0 0
# 0 1 0 0 0
# 0 0 0 0 1
# 2 3 ( 각 사람들이 가고자 하는 편의점)
# 4 4
# 5 1

def find_base(ip):
    global v
    dx = [-1, 0, 0, 1]
    dy = [0, -1, 1, 0]
    result=[]



    x,y=conv[ip][0],conv[ip][1]


    stores=[]
    minNum=1e9
    q=deque()
    q.append((x,y))

    visited=[[0]*N for _ in range(N)]
    visited[x][y]=1

    stores=[]
    minNums=1e9
    ff=False
    while q:

        x,y=q.popleft()
        if board[x][y]==1:
            v[x][y]=True
            return x,y,
            break

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<N and 0<=ny<N and v[nx][ny]==False and visited[nx][ny]==False:
                q.append((nx,ny))
                visited[nx][ny]=True





    #print(stores)

    # while q:
    #
    #     x,y=q.popleft()
    #
    #     for d in range(4):
    #         nx=x+dx[d]
    #         ny=y+dy[d]
    #
    #         if 0<=nx<N and 0<=ny<N:
    #             if visited[nx][ny]==0 and v[nx][ny]==False:
    #                 visited[nx][ny]=visited[x][y]+1
    #                 q.append((nx,ny))
    #
    # for i in range(N):
    #     for j in range(N):
    #         if board[i][j]==1 and v[i][j]==False and visited[i][j]!=0:
    #             minNum=min(minNum,visited[i][j])
    #
    #
    # #print("minNum",minNum)
    # for i in range(N):
    #     for j in range(N):
    #         if board[i][j]==1 and visited[i][j]==minNum:
    #             stores.append((i,j))
    #






N,M=map(int,input().split())
board=[list(map(int,input().split()))for _ in range(N)]

conv=[]

for i in range(M):
    x,y=map(int,input().split())
    conv.append([x-1,y-1])
v=[[False]*N for _ in range(N)]


time=0
people=[[-1,-1] for _ in range(M)]
#people)
def bfs(x,y,cx,cy):
    global v
    q=deque()

    lst=[]
    q.append((x,y,lst))
    vvisited=[[False]*N for _ in range(N)]
    vvisited[x][y]=True

    dx=[-1,0,0,1]
    dy=[0,-1,1,0]
    t=0

    while q:
        t+=1
        x,y,l=q.popleft()

        if x==cx and y==cy:


            return l[0][0],l[0][1]

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]

            if 0<=nx<N and 0<=ny<N:
                if vvisited[nx][ny]==False and v[nx][ny]==False:
                    q.append((nx,ny,l+[[nx,ny]]))
                    vvisited[nx][ny]=True





while True:

    # 1동안
    time+=1

    #print(time,"초@@")
    for i in range(M):
        #print(i,"번 사람")
        x,y=people[i][0],people[i][1]
        if x==-2 and y==-2:
            continue
        elif x!= -1 and y != -1:
            #print(i)
            cx,cy=conv[i][0],conv[i][1]
            #print("시작점",x,y)
            #print("편의점",cx,cy)

            people[i][0],people[i][1]=bfs(x,y,cx,cy)

            if people[i][0]==cx and people[i][1]==cy:
                v[people[i][0]][people[i][1]]=True
                people[i][0]=-2
                people[i][1]=-2



    if time<=M:

        #print(time)
        # if people[i]==[-1,-1]: # base 넣기
        #print(time,"의 베이스")
        cx,cy=find_base(time-1)
        #print(cx,cy)
        people[time-1][0]=cx
        people[time-1][1]=cy



    #print("현재상황",people)

    flag=True

    for i in range(M):
        if people[i][0]!= -2 and people[i][1]!=-2:
            flag=False

    if flag:
        print(time)
        break

    # for i in v:
    #     print(i)
    # print()
    #rint("@@@@@@@@@@@@")
