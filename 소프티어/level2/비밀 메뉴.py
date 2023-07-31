M,N,K=map(int,input().split())
secret=list((input().split()))
#
s="".join(secret)
#print(s)
num=list(input().split())
n="".join(num)

check=False
for i in range(len(num)-len(secret)+1):
    #print("s",secret)
    #print(num[i:i+len(secret)])
    temp=num[i:i+4]
    if secret==num[i:i+len(secret)]:
        check=True
        break
if check:
    print("secret")
else:
    print("normal")

