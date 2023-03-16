import sys
from collections import deque

N, M, K, X = map(int, sys.stdin.readline().split())

graph_li = [[] for i in range(N + 1)]
for _ in range(M):
    x, y = map(int, sys.stdin.readline().split())
    graph_li[x].append(y)

graph_li = deque(graph_li)
count_li = [2 ** 31 for _ in range(N + 1)]


def func(X, K):
    queue = deque()
    queue.append([0, X])  ## append [count, X]
    count_li[X] = 0

    while (queue):
        count, X = queue.popleft()

        if graph_li[X] == []:
            continue

        if count > K:
            break

        for y in graph_li[X]:
            if count < count_li[y]:
                count_li[y] = count + 1
                queue.append([count + 1, y])

            """
            if count_li[y] == -1:
                count_li[y] = count
                queue.append(y)
            """


func(X, K)

tmp = False

for i in range(1, len(count_li)):
    if count_li[i] == K:
        print(i)
        tmp = True

    if tmp == False and i == len(count_li) - 1:
        print(-1)