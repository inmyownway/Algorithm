import sys

n = int(input())

cranes = list(map(int,input().split()))
box = int(input())
weight=  list(map(int,input().split()))


# sort
# 6 8 9
## 2 2 4 5 7


# 9 8 6
# 7 5 4 2 2


cranes.sort(reverse=True)
weight.sort(reverse=True)

time = 0
if cranes[0] < weight[0]:
    print(-1)
    sys.exit()

while len(weight)>0:
    for crane in cranes:
        for w in weight:
            if crane >= w:
                weight.remove(w)
                break
    time+=1

print(time)
