import copy
from collections import deque
from itertools import combinations

n,m,d=map(int,input().split())
graph=[list(map(int,input().split())) for _ in range(n)]
items =[ i for i in range(m)]
result= 0
#print(items)
def is_empty():
    for i in range(n):
        for j in range(m):
            if temp[i][j]==1:
                return False
    return True
def attacK(a):

    attacK_list=list()
    cnt=0
    for l in a:
        pos=list()
        for i in range(n):
            for j in range(m):
                if temp[i][j]==1:
                    now_d = abs(i-n)+abs(j-l)
                    if d>=now_d:
                        pos.append((now_d,i,j))
        pos.sort(key=(lambda x: (x[0],x[2])))
        if pos:
            attacK_list.append(pos[0])
    for b in attacK_list:
        _,i,j=b
        if temp[i][j]==1:
            temp[i][j]=0
            cnt+=1
    return cnt

def move():
    for i in range(-1,-n,-1):
        temp[i]=temp[i-1]
    temp[0]= [0 for _ in range(m)]



for a in combinations(items,3):

    temp=copy.deepcopy(graph)
    count=0
    while not is_empty():
        count+=attacK(a)
        move()
    result=max(result,count)
print(result)
#
# graph=[]
# e=deque()
# for i in range(n):
#     temp=list(map(int,input().split()))
#     # for j in range(len(temp)):
#     #     if temp[j]==1:
#     #         e.append((i,j))
#     graph.append(temp)
#
# archor=[]
# for i in range(m):
#     s=0
#     for j in range(n):
#         s+=graph[j][i]
#     archor.append([s,i])
#
# archor.sort(reverse=True)
# a1=archor[0][1]
# a2=archor[1][1]
# a3=archor[2][1]
#
# archor_line=[a1,a2,a3]
# kill=0
#
# while True:
#     b=True
#     temp=d
#     result = 0
#     for a in graph:
#         result+=sum(a)
#     if result==0:
#         break
#
#
#
#     count=0
#     for i in range(d):
#         print(i)
#         for j in archor_line:
#             if graph[n-1-i][j]==1:
#                 kill+=1
#                 count+=1
#                 graph[n-1-i][j]=0
#
#                 if count>=3:
#                     b=False
#                     break
#         if b==False:
#             break
#     #
#     # for ix in graph:
#     #     print(ix)
#     # print()
#
#
#
#     for i in range(n):
#         for j in range(m):
#             if graph[i][j]==1:
#                 e.append((i,j))
#     t_e=len(e)
#     print(e)
#
#
#     for ix in graph:
#         print(ix)
#     print()
#
#     for i in range(t_e):
#         x,y=e.pop()
#         print(x,y)
#         graph[x][y]=0
#         if x+1 < n:
#             graph[x+1][y]=1
#             #print(graph[x+1][y])
#
#     for ix in graph:
#         print(ix)
#     print()
#
# print(kill)
#
#
#
#
#
#
#
#
#
#
#
#
