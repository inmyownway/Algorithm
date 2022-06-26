


d_list = list(map(int, input().split()))
num_matrix = len(d_list)
print(num_matrix)
l =  [[0]*num_matrix]*(num_matrix)
print(l)
i = 1
j = num_matrix-1
temp1 = 1
temp2 = 0
while True:
    temp2 = temp1
    for a in range(i,j):
        temp2 += 1
        min =9999
        for k in range(a,temp2):
            temp = l[a][k]+l[k+1][temp2]+(d_list[a-1]*d_list[k]*d_list[temp2])

            if min > temp:
                min = temp
                print(min)
        l[a][temp2]=min
        print(l)
        temp1 += 1

    j-=1

    if i==j:
        break

print("결과",l)
