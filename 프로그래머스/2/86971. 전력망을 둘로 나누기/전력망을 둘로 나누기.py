from collections import deque
def bfs(start, visited, grpah):
    queue = deque([start])
    result = 1
    visited[start] = True
    while queue:
        n = queue.popleft()

        for i in grpah[n]:
            if visited[i] == False:
                result += 1
                queue.append(i)
                visited[i] = True
    return result
def solution(n, wires):
   

    graph = [[] for _ in range(n+1)]
    answer = n
    for wire in wires:
        graph[wire[0]].append(wire[1])
        graph[wire[1]].append(wire[0])

    for start,disconnect in wires:
        visited= [False] * (n+1)
        visited[disconnect]=True
        result =bfs(start,visited,graph)
        if abs(result - (n - result)) < answer:
            answer = abs(result - (n - result))
    
    return answer