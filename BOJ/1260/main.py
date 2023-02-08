import sys
from collections import deque

sys.setrecursionlimit(10001)

N, M, V = map(int, sys.stdin.readline().split())
visited_dfs = [0 for i in range(N + 1)]
visited_bfs = [0 for i in range(N + 1)]
count_dfs = []
count_bfs = []
graph_li = [[] for i in range(N + 1)]

for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph_li[u].append(v)
    graph_li[v].append(u)

for i in range(N + 1):
    graph_li[i].sort()


def dfs(cur_node, count=1):
    visited_dfs[cur_node] = count
    count_dfs.append(cur_node)
    for next_node in graph_li[cur_node]:
        if visited_dfs[next_node] == 0:
            dfs(next_node, count + 1)


def bfs(start_node):
    count = 1
    queue = deque()
    for next_node in graph_li[start_node]:
        queue.append(next_node)
    visited_bfs[start_node] = count
    count_bfs.append(start_node)

    while (queue):
        next_node = queue.popleft()
        if visited_bfs[next_node] == 0:
            count += 1
            visited_bfs[next_node] = count
            count_bfs.append(next_node)
            for after_next_node in graph_li[next_node]:
                queue.append(after_next_node)


dfs(V)
bfs(V)
for i in range(len(count_dfs)):
    print(count_dfs[i], end=" ")
print()
for i in range(len(count_bfs)):
    print(count_bfs[i], end=" ")