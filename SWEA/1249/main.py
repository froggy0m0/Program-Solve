from collections import deque
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
T = int(input())
for testCaseCount in range(1, T+1):
    N = int(input())

    mapList = []
    for i in range(N):
        mapList.append(list(map(int, input())))

    visitedList = [[2 ** 31 for _ in range(N)] for _ in range(N)]
    visitedList[0][0] = 0
    queue = deque()
    queue.append([0,0])
    while(queue):
        currentX, currentY = queue.popleft()

        for i in range(4):
            nextX = currentX + dx[i]
            nextY = currentY + dy[i]
            if -1 < nextX < N and -1 < nextY < N:
                if (visitedList[currentX][currentY] + mapList[nextX][nextY] < visitedList[nextX][nextY]):
                    visitedList[nextX][nextY] = visitedList[currentX][currentY] + mapList[nextX][nextY]
                    queue.append([nextX, nextY])

    print(f"#{testCaseCount}", visitedList[N - 1][N - 1])
