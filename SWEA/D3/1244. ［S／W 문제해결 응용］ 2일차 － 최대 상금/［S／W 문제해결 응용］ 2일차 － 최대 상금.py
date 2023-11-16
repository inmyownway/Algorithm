test_case=int(input())
def dfs(count):

    global answer

    if count==0:

        temp=int(''.join(values))

        if answer<temp:
            answer=temp
        return

    for i in range(length):

        for j in range(i+1,length):
            values[i],values[j]=values[j],values[i]

            temp_key=''.join(values)

            if visited.get((temp_key,count-1),1):

                visited[(temp_key,count-1)]=0
                dfs(count-1)
            values[i],values[j]=values[j],values[i]


for test in range(1,test_case+1):

   answer=-1

   value,change=input().split()

   values=list(value)
   change=int(change)
   length=len(value)

   visited={}
   dfs(change)
   print("#%d %d"%(test,answer))