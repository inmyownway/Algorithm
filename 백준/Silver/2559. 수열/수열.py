
n,m=map(int,input().split())
day =list(map(int,input().split()))
# max = -1
# for i in range (n-m):
#     # if i+m > len(day):
#     #     continue
#     sum=0
#     for j in range(i,i+m):
#         sum+=day[j]
#     if max < sum:
#         max =sum
result =[]

temp =sum(day[:m])

result.append(temp)

for i in range(0,n-m):
    temp = temp - day[i]+day[i+m]
    result.append(temp)

print(max(result))
