# 3 1 1
# 3 1 1 2
# 3 1 2 1 1 2
from collections import Counter
r , c ,k=map(int,input().split())
r,c,=r-1,c-1
#print(k)
matrix=[]
for _ in range(3):
    matrix.append(list(map(int,input().split())))
#print("초기")
#print(matrix)
# for i in matrix:
#     print(i)
#print()
time=0
def cal(matrixs):
    global matrix
    new_matrix = []

    for i in range(len(matrix)):
        new=[]
        x=Counter(matrix[i])
        del x[0]
        x=list(x.items())
        x.sort(key=lambda x:(x[1],x[0]))
        if len(x)>50:
            x=x[:50]
        for a,b in x:
            new.append(a)
            new.append(b)
        new_matrix.append(new)


    #print(new_matrix)
    maxNum=-1
    for i in range(len(new_matrix)):
        maxNum=max(maxNum,len(new_matrix[i]))


    #print(maxNum)
    for i in range(len(new_matrix)):
        if len(new_matrix[i])<maxNum:
            for j in range(maxNum-len(new_matrix[i])):
                new_matrix[i].append(0)
    #print("0추가",new_matrix)
    matrix=new_matrix


while True:
    #print(time)
    #print(r,c,matrix[r][c],k)
    if r< len(matrix) and c<len(matrix[0]):
        if matrix[r][c] ==k:
            print(time)
            break
    if len(matrix)>=len(matrix[0]):
        cal(matrix)
    else:
        matrix=list(map(list,zip(*matrix)))
        cal(matrix)
        matrix=list(map(list,zip(*matrix)))
    time+=1

    # for i in matrix:
    #     print(i)
    # print()
    if time>100:
        print(-1)
        break
    if r< len(matrix) and c<len(matrix[0]):
        if matrix[r][c]==k:
            print(time)
            break