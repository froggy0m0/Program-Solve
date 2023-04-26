import sys, copy
from collections import deque
from itertools import combinations


def bfs(x,y):
    queue = deque()
    queue.append([x,y])
    while(queue):
        x,y = queue.popleft()
        for i in range(4):
            nextX = x + moveX[i]

            nextY = y + moveY[i]
            if -1 < nextX < N and -1 < nextY < M:
                if mapCopyList[x][y] == 2 and mapCopyList[nextX][nextY] == 0:
                    mapCopyList[nextX][nextY] = 2
                    queue.append([nextX, nextY])

N, M = map(int, sys.stdin.readline().split())
mapList = []
for i in range(N):
    mapList.append(list(map(int, sys.stdin.readline().split())))
maxCount = 0
moveX = [1, -1, 0, 0]
moveY = [0, 0, 1, -1]


combin = list(combinations([i for i in range(N*M)], 3))

for wall1,wall2,wall3 in combin:
    x1, y1 = wall1 // M, wall1 % M
    x2, y2 = wall2 // M, wall2 % M
    x3, y3 = wall3 // M, wall3 % M

    if (mapList[x1][y1] == 0 and mapList[x2][y2] == 0 and mapList[x3][y3] == 0):
        mapCopyList = copy.deepcopy(mapList)
        tmpCount = 0

        mapCopyList[x1][y1] = 1
        mapCopyList[x2][y2] = 1
        mapCopyList[x3][y3] = 1

        for x in range(N):
            for y in range(M):
                if (mapCopyList[x][y] == 2):
                    bfs(x,y)

        for row in mapCopyList:
            tmpCount += row.count(0)

        if maxCount < tmpCount:
            maxCount = tmpCount

print(maxCount)