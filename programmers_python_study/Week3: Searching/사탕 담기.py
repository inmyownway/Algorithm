import itertools


def solution(m, weights):
    count = 0

    for l in range(len(weights)):
        a = list(itertools.combinations(weights, l))
        for i in a:
            sum = 0
            for x in i:
                sum += x
            if sum == m:
                count += 1
    return count