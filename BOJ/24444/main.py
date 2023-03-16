import sys
from collections import deque

N, M, R = map(int, sys.stdin.readline().split())
visited = [0 for i in range(N+1)]
graph_li = [[] for i in range(N+1)]

for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph_li[u].append(v)
    graph_li[v].append(u)

for i in range(N):
    graph_li[i].sort()

queue = deque()
for v in graph_li[R]:
    queue.append(v)
count = 1
visited[R] = count

while(queue):
    v = queue.popleft()
    if visited[v] == 0:
        count += 1
        visited[v] = count
        for next_v in graph_li[v]:
            queue.append(next_v)

for i in range(1, N+1):
    print(visited[i])