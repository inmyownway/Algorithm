n,m=map(int,input().split())

rooms={}

for _ in range(n):
    room=input()
    rooms[room]=[0]*18+[1]

for i in range(m):
    name,start,end=input().split()

    for j in range(int(start),int(end)):
        rooms[name][j]=1
print(rooms)
rooms=dict(sorted(rooms.items()))
print(rooms)
for r in rooms:
    print(r[0][1])


