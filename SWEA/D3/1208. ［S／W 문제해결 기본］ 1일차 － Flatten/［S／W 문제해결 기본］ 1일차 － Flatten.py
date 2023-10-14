
test_case=10

for test in range(1,test_case+1):

    cnt=int(input())
    l=list(map(int,input().split()))


    # maxNum=max(l)
    # maxNum_idx=l.index(maxNum)

    for i in range(cnt):
        l.sort()
        l[-1]-=1
        l[0]+=1

    l.sort()
    print("#{} {}".format(test,l[-1]-l[0]))