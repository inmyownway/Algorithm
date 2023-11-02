from collections import deque

test_case = int(input())

def bfs(x,y):
    q=deque()
    q.append([x,y])

    while q:


        x, y = q.popleft()
        if abs(x - fx) + abs(y - fy) <= 1000:
            print("happy")
            return

        for i in range(conv_num):
            if not visited[i]:
                new_x,new_y=conv[i]
                if abs(x - new_x) + abs(y - new_y) <= 1000:
                    q.append([new_x,new_y])
                    visited[i]=1

    print("sad")
    return



for test in range(test_case):
    conv_num = int(input())

    x, y = map(int, input().split())
    conv = []

    for i in range(conv_num):
        cx, cy = map(int, input().split())
        conv.append([cx, cy])

    fx,fy=map(int,input().split())

    visited=[0 for _ in range(conv_num+1)]

    bfs(x,y)
