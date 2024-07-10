import sys
N = int(input())

arr = list(map(int, sys.stdin.readline().split()))
arr.sort()
ans =0

for i in range(N):
    temp = arr[:i]+arr[i+1:]

    left= 0
    right= len(temp)-1

    while left < right:
        mid = temp[left] + temp[right]

        if mid == arr[i]:
            ans+=1
            break

        if mid < arr[i]:
            left+=1
        else:
            right-=1
print(ans)