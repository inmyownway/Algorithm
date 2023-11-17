from collections import deque

test_case=int(input())
for test in range(1,test_case+1):
    N,M,K=map(int,input().split())

    guest=list(map(int,input().split()))

    guest.sort()

    time=0
    fish=0

    idx=0

    flag="Possible"
    while True:


        if time!=0 and time%M==0:
            fish+=K

        if time==guest[idx]:
            fish-=1

            if fish<0:
                flag="Impossible"
                break
            idx+=1

        if time==guest[-1]:
            break
        time+=1

    print("#%d %s"%(test,flag))










