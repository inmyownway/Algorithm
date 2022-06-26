
def solution(s):
    s = list(s)
    print(s)
    stack = []
    # x y b  -> yb
    for i in s:
        while stack and stack[-1] < i:
            stack.pop()
        stack.append(i)

    return ''.join(stack)




