input_list = list(map(float, input().split()))
num_matrix = len(input_list)




l =  [[1.000 for col in range(num_matrix+1)] for row in range(num_matrix+1)]
table_k= [[0 for col in range(num_matrix+1)] for row in range(num_matrix+1)]
j = num_matrix

for i in range(1,j+1):
    table_k[i][i]=i

def opt(a,b):
    min = 9999.0
    for k in range(a,b+1):
        t1 = 0.00
        t2 = 0.00
        temp = 0.00
        m=0.00
        for q in range(a,b+1):
            m+=input_list[q-1]

        if a<=k-1:
            for x in range(a,k):
                t1+=input_list[x-1]
            temp+=(t1/m)*l[a][k-1]
        if k+1 <=b:
            for y in range(k+1,b+1):
                t2+=input_list[y-1]
            temp+=(t2/m)*l[k+1][b]
        temp += 1.0

        if min > temp:
            min = temp
            table_k[a][b]=k;
    return min
tmp1 = 2
tmp2 =0
while True:
    tmp2 += tmp1
    for i in range(1, j):
       l[i][tmp2]=opt(i, tmp2)

       tmp2 += 1
    tmp2 = 0
    tmp1 += 1
    j-=1
    if i > j:
        break
print("table of opt(i,j)\n")
for x in range (1,num_matrix+1):
    for y in range(1,num_matrix+1):
        if x > y:
            print(" ".ljust(4),end=' ')
        else:
            l[x][y] = format(l[x][y], ".2f")
            print(str(l[x][y]).rjust(4),end=' ')
    print()
print("\ntable of k(i,j)\n")
for x in range (1,num_matrix+1):
    for y in range(1,num_matrix+1):
        if x > y:
            print(" ".rjust(3), end=' ')
        else:
            print(str(table_k[x][y]).rjust(3),end=' ')
    print()
