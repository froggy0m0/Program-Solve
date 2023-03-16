import sys
from collections import deque

N = int(sys.stdin.readline())
map_li = [list(map(int, sys.stdin.readline().strip())) for _ in range(N)]

count_li = []


def func(x, y):
    global count
    map_li[x][y] = 'True'
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    for i in range(4):
        x_idx = x + dx[i]
        y_idx = y + dy[i]
        if x_idx > -1 and x_idx < N and y_idx > -1 and y_idx < N:
            if map_li[x_idx][y_idx] == 1:
                map_li[x_idx][y_idx] = 'True'
                count += 1
                func(x_idx, y_idx)


for x in range(N):
    for y in range(N):
        if map_li[x][y] == 1:
            count = 1
            func(x, y)
            count_li.append(count)

count_li.sort()
print(len(count_li))
print(*count_li, sep="\n")