

for test in range(1,10+1):
    n=int(input())
    lst=list(input())

    stack=list()
    left=["(","{","[","<"]
    right=[")","}","]",">"]
    for i in range(len(lst)):
        if lst[i] in left:
            stack.append(lst[i])
        if lst[i] in right:
            # 가장 상위의 괄호 값과 쌍이라면
            if right.index(lst[i]) == left.index(stack[-1]):
                # 상위의 원소 제거하기
                stack.pop()
            else:
                break
    res=0
    #print(stack)
    if len(stack)==0:
        res=1

    print("#%d %d"%(test,res))
