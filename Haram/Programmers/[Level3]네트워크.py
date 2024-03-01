from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(n, computers, visited, start):
    global dx, dy, answer
    
    q = deque()
    q.append(start)
    
    while q:
        node = q.popleft()
    
        if visited[node]: 
            continue
        visited[node] = True
        for i in range(n):
            if computers[node][i] == 1 and not visited[i]:
                q.append(i)
    
def solution(n, computers):
    answer = 0
    
    visited = [False for _ in range(n)]
    
    for i in range(n):
        if visited[i]:
            continue
        bfs(n, computers, visited, i)
        answer += 1
            
    return answer