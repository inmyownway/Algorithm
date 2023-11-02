H,M=map(int,input().split())


flag=False

if M-45<0:
    M=60-abs(M-45)
    flag=True
else:
    M=M-45


if flag:
    H=H-1
    if H<0:
        H=23

print(H,M)