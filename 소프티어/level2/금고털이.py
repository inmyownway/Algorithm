import sys

W, N = map(int, input().split())

l = []
for i in range(N):
    x, y = map(int, input().split())
    l.append([x, y])

# l.sort(key= lambda x:(-x[1]))
# l=l.sort(lambda x: l[0])
# data_list.sort(key=lambda x : len(x))
# print(l)
#
l.sort(key=lambda x: (-x[1]))
ww = W
ans = 0
# print(l)
for lst in l:

    weight = lst[0]
    price = lst[1]

    if ww > weight:
        ww -= weight
        ans += weight * price
    else:
        ans += ww * price
        break

print(ans)


