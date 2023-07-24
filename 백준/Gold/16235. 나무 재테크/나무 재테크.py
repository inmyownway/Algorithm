from collections import deque
N,M,K=map(int,input().split())
# N*N , 1부터 시작
# M개의 나무 심었다
# 봄에는 (나이만큼)양분을 머고 나이가 1 증가
# 하나의 칸에 여려개의 나무가 잇다면 어린 나무부터
# 나이만큼 양분을 못먹으면 죽음
# 여름에는 죽은 나무가 양분으로 변함
# 죽은나무 나이 // 2 로 양분 추가
# 겨울에는 나무가 번식 나이가 5배수여야함 , 인접8칸에 생킴
ground=[[5]*N for _ in range(N)]
soil=[]
for i in range(N):
    soil.append(list(map(int,input().split())))
#
tree=[[[] for _ in range(N)] for _ in range(N)]


for _ in range (M):
    x,y,z=map(int,input().split())
    tree[x-1][y-1].append(z)

# 봄 여름

for _ in range(K):

    for i in range(N):
        for j in range(N):
            if tree[i][j]:
                tree[i][j].sort()

                tmp_live_tree=[]
                death=0

                for age in tree[i][j]:
                    if age<=ground[i][j]:
                        ground[i][j]-=age
                        age+=1
                        tmp_live_tree.append(age)
                    else:
                        death+=age//2

                tree[i][j].clear()
                tree[i][j].extend(tmp_live_tree)
                ground[i][j]+=death

    # 겨울

    dx=[0,0,-1,1,-1,-1,1,1]
    dy=[1,-1,0,0,-1,1,-1,1]

    for i in range(N):
        for j in range(N):
            if tree[i][j]:
                for age in tree[i][j]:
                    if age%5==0:

                        for dir in range(8):
                            nx=i+dx[dir]
                            ny=j+dy[dir]

                            if 0<=nx<N and 0<=ny<N:
                                tree[nx][ny].append(1)
    #print(tree)
    ##print(y)
    #rint(ground)
    for i in range(N):
        for j in range(N):
            ground[i][j]+=soil[i][j]

answer=0
for i in range(N):
    for j in range(N):
        answer+=len(tree[i][j])
print(answer)












