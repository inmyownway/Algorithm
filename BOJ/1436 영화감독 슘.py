
n = int(input())
result = 666

count = 0

while True:
    if "666" in str(result):
        count+=1
        if n == count:
            print(result)
            break
    result+=1