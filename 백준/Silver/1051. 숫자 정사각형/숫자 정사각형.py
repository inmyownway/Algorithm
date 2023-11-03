N,M=map(int,input().split())
l=[]

d=min(N,M)
for i in range(N):
    t=list(input())

    l.append(t)


answer=[]
answer.append(1)
for num in range(1,d):
    #print("num:",num)






    for i in range(N-num):
       #print(i,"i일떄")
        for j in range(M-num):
            #print(j)
            n1=l[i][j]
            n2=l[i+num][j]
            n3=l[i][j+num]
            n4=l[i+num][j+num]

            if n1==n2 and n1==n3 and n1==n4:
                answer.append((num+1)*(num+1))

print(max(answer))