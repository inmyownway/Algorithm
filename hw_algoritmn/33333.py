d_list = list(map(int, input().split()))
num_matrix = len(d_list)
l =  [[0 for col in range(num_matrix)] for row in range(num_matrix)]
table_k= [[0 for col in range(num_matrix)] for row in range(num_matrix)]
j = num_matrix
tmp1 = 2
tmp2 =0
def opt(a,b):
    min = 9999
    for k in range(a,b):
        temp = l[a][k] + l[k + 1][b] + (d_list[a - 1] * d_list[k] * d_list[b])

        if min > temp:
            min = temp
            table_k[a][b]=k;
    return min
while True:
    tmp2 += tmp1
    for i in range(1, j-1):
       l[i][tmp2]=opt(i, tmp2)
       tmp2 += 1
    tmp2 = 0
    tmp1 += 1
    j-=1
    if i > j:
        break
print("table of opt(i,j)\n")
for x in range (1,num_matrix):
    for y in range(1,num_matrix):
        if x > y:
            print(" ".rjust(3),end=' ')
        else:
            print(str(l[x][y]).rjust(3),end=' ')
    print()
print("\ntable of k(i,j)\n")
for x in range (1,num_matrix):
    for y in range(1,num_matrix):
        if x > y:
            print(" ".rjust(3), end=' ')
        else:
            print(str(table_k[x][y]).rjust(3),end=' ')
    print()
