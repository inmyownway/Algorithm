def solution(n):
    answer = 0
    l = []
    l.append(1)
    l.append(2)
    for i in range(3, n + 1):
        l.append(((l[-1] + l[-2]) % 1000000007))

    return l[-1]