
tese_case=int(input())
for tese_case1 in range(1,tese_case+1):
    n=int(input())

    result=[input() for _ in range(n)]

    result=list(set(result))
    a = sorted(result, key=lambda x: (len(x), x))

    print("#%d"%(tese_case1))
    for name in a:
        print(name)