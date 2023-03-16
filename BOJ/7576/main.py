import sys
from collections import deque

nx = [-1, 1, 0, 0]
ny = [0, 0, -1, 1]

M, N = map(int, sys.stdin.readline().split())
li = list()

for _ in range(N):
    li.append(list(map(int, sys.stdin.readline().split())))

start_li = []
for x in range(N):
    for y in range(M):
        if li[x][y] == 1:
            start_li.append([x, y])


def bfs(start):
    queue = deque(start)
    while queue:
        current_x, current_y = queue.popleft()
        for i in range(4):
            target_x = current_x + nx[i]
            target_y = current_y + ny[i]

            if target_x <= -1 or target_x >= N or target_y <= -1 or target_y >= M:
                continue

            if li[target_x][target_y] == 0:
                li[target_x][target_y] = int(li[current_x][current_y]) + 1
                queue.append([target_x, target_y])


bfs(start_li)
check = False
res = 0
for i in range(N):
    tmp = max(li[i])
    res = tmp if res < tmp else res
    if check == False and li[i].count(0) > 0:
        check = True

print(-1 if check == True else res - 1)