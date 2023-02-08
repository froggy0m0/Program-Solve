import sys
from collections import deque

sys.setrecursionlimit(10 ** 6)
T = int(sys.stdin.readline())


def func():
    count = 0
    M, N, K = map(int, sys.stdin.readline().split())

    graph_li = [[0 for _ in range(N)] for _ in range(M)]
    for _ in range(K):
        x, y = map(int, sys.stdin.readline().split())
        graph_li[x][y] = 1

    def bfs(x, y):
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        graph_li[x][y] = '1'
        for i in range(4):
            x_idx = x + dx[i]
            y_idx = y + dy[i]
            if x_idx > -1 and x_idx < M and y_idx > -1 and y_idx < N:
                if graph_li[x_idx][y_idx] == 1:
                    graph_li[x_idx][y_idx] = '1'
                    bfs(x_idx, y_idx)

    for x in range(M):
        for y in range(N):
            if graph_li[x][y] == 1:
                count += 1
                bfs(x, y)
    print(count)


for i in range(T):
    func()
