import sys
from collections import deque
sys.setrecursionlimit(200001)
def func(R):
    global count
    count += 1
    visited[R] = count
    for v in graph_li[R]:
        if visited[v] == 0:
            func(v)
count = 0
N, M, R = map(int, sys.stdin.readline().split())
visited = [0 for i in range(N+1)]
graph_li = [[] for i in range(N+1)]
for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph_li[u].append(v)
    graph_li[v].append(u)
for i in range(N+1):
    graph_li[i].sort(key=lambda x:-x)

func(R)
for i in range(1,N+1):
    print(visited[i])