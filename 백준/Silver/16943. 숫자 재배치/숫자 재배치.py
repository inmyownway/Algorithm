from itertools import permutations

A,B=map(int,input().split())

p=list(permutations(list(str(A)),len(str(A))))

#print(p)
maxNum=-1e9
for num in p:

    n=int(''.join(num))

    if len(str(n))==len(str(A)):
        if int(n)<B:
             maxNum=max(maxNum,int(n))
if maxNum==-1e9:
    print(-1)
else:

    print(maxNum)