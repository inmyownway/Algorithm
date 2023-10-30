import sys


lst=input()

explosion_str= input()


# stack=[]
#
# for i in range(len(lst)):
#     stack.append(lst[i])
#     if ''.join(stack[-len(explosion_str):])==explosion_str:
#         for _ in range(len(explosion_str)):
#             stack.pop()

stack = []
ex_len = len(explosion_str)

for i in range(len(lst)):
    stack.append(lst[i])
    if ''.join(stack[-ex_len:]) == explosion_str:
        for _ in range(ex_len):
            stack.pop()
if stack:
    print(''.join(stack))
else:
    print("FRULA")
