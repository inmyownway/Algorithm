
test_case=int(input())

for test in range(1,test_case+1):
    N=int(input())

    board=[]
    for i in range(N):
        t=list(input())
        board.append(t)

    dx=[0,0,-1,1,-1,-1,1,1]
    dy=[-1,1,0,0,-1,1,-1,1]
    flag=False
    for i in range(N):
        for j in range(N):
            #print("@",i,j)
            if board[i][j]=='o':


                for d in range(8):
                    nx=i
                    ny=j
                    #print(d)
                    cnt=0
                    for move in range(4):

                        nx+=dx[d]
                        ny+=dy[d]

                        if 0<=nx<N and 0<=ny<N:
                            if board[nx][ny]=='o':
                                #print(nx,ny)
                                cnt+=1
                    if cnt>=4:
                        flag=True
    if flag:
        print("#%d YES"%(test))
    else:
        print("#%d NO"%(test))




