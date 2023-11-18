

test_case=int(input())
def isPrime(num):

    for i in range(2,num):
        if num%i==0:
            return False
    return True


numLst=[]
for i in range(2,1000):
    if isPrime(i):
        numLst.append(i)

for test in range(1,test_case+1):
    tc=int(input())




    cnt=0

    # 2 3 5
    for x in range(len(numLst)):
        if numLst[x]==tc:
            break
        for y in range(x,len(numLst)):
            if numLst[y] == tc:
                break
            for z in range(y,len(numLst)):
                if numLst[z] == tc:
                    break

                if numLst[x]+numLst[y]+numLst[z]==tc:
                    #print(numLst[x], numLst[y], numLst[z])
                    cnt+=1





    print("#%d %d"%(test,cnt))


