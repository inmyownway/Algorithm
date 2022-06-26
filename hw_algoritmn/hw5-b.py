list = [0 for _ in range(1000)]
f = open("/Users/jungmin/Desktop/ana.txt", 'rt')
while True:
    line = f.readline()
    if not line:
        break
    raw = line.split()
    for words in raw:
        for i in range(0,len(words)):
           # n = int(ord(a[i]))
            n=int(ord(words[i]))
            list[n] +=1

for i in range(0,128):
    print("count["+str(i) +"]"+ "=",list[i],)





f.close()
print("@#@#@##")
list.sort()
list.reverse()
sum = 0
for i in list:
    sum += i
print(sum)