import sys
from collections import deque
N, M = map(int, sys.stdin.readline().split())
locationList = [list(map(int ,sys.stdin.readline().strip())) for _ in range(N)]
visited = [[[0] * 2 for _ in range(M)] for _ in range(N)]

def bfs():
    dx = [1,-1, 0, 0]
    dy = [0, 0, 1, -1]
    visited[0][0][0] = 1
    queue = deque([[0, 0, 0]])
    while(queue):
        currentX, currentY, crashed = queue.popleft()

        if currentX == N-1 and currentY == M-1 :
            return visited[currentX][currentY][crashed]

        for i in range(4):
            nextX = currentX + dx[i]
            nextY = currentY + dy[i]

            if 0<=nextX<N and 0<=nextY<M:
                if locationList[nextX][nextY] == 0 and visited[nextX][nextY][crashed] == 0:
                    visited[nextX][nextY][crashed] = visited[currentX][currentY][crashed] + 1
                    queue.append([nextX, nextY, crashed])

                elif locationList[nextX][nextY] == 1 and visited[nextX][nextY][crashed] == 0:
                    if crashed == 0 :
                        visited[nextX][nextY][1] = visited[currentX][currentY][crashed] + 1
                        queue.append([nextX, nextY, 1])
    return -1
print(bfs())
