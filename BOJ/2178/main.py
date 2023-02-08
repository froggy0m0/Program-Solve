import sys
from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

N, M = map(int, sys.stdin.readline().split())
graph_li = [list(sys.stdin.readline().strip()) for _ in range(N)]
graph_li[0][0] = 1


queue = deque()
queue.append([0,0])
while(queue):
    x,y = queue.popleft()
    for i in range(4):
        x_idx = x + dx[i]
        y_idx = y + dy[i]
        if x_idx > -1 and x_idx < N and y_idx > -1 and y_idx < M:
            if graph_li[x_idx][y_idx] == '1':
                graph_li[x_idx][y_idx] = graph_li[x][y] + 1
                queue.append([x_idx, y_idx])
    if graph_li[N-1][M-1] != '1':
        print(graph_li[N-1][M-1])
        break