
l=[]
for i in range(5):
    t=list(input())
    if len(t)<15:
        for j in range(15-len(t)):
            t.append(" ")
    l.append(t)#print(l)

answer=""
for i in range(15):
    temp=""
    for j in range(5):
        if not l[j][i]==" ":
            temp+=l[j][i]
    answer+=temp
print(answer)
