import sys
from collections import deque

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

li = [[] for _ in range(N + 1)]
visited = [0 for _ in range(N + 1)]
for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    li[u].append(v)
    li[v].append(u)

for i in range(1, N + 1):
    li[i].sort()

graph_li = deque(li)


def func():
    queue = deque()
    for v in graph_li[1]:
        queue.append([1, v])
    count = 0
    visited[1] = 1
    while (queue):
        u, v = queue.popleft()

        if visited[v] == 0:
            visited[v] = 1
            count += 1

            for v2 in graph_li[v]:
                if visited[v2] == 0:
                    queue.append([v, v2])

    return count


res = func()
print(res)