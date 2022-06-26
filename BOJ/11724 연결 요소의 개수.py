import sys
sys.setrecursionlimit(100000)

n,m = map(int,input().split())
l = [[] for _ in range (n+1) ]
check = [False] * (n+1)
for _ in range (m):
    a,b = map(int,input().split())
    l[a-1].append(b-1)
    l[b-1].append(a-1)
for i in l:
    i.sort()


def dfs(x):
    #global check
    check[x] = True
    for i in l[x]:
        if check[i] == False:
            dfs(i)
count = 0
for i in range(n):
    if check[i] == False:
        dfs(i)
        count += 1

print(count)

