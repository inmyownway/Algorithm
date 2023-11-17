
test_case=int(input())
for test in range(1,test_case+1):
    tc=int(input())

    nums=list(map(int,input().split()))

    result=[0]
    for i in nums:
        t=[]
        for j in result:
            temp=j+i

            t.append(temp)

        result+=t
        result=list(set(result))
    print("#%d %d"%(test,len(result)))