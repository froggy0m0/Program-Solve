from collections import deque
movX =[1, -1, 0, 0]
movY =[0, 0, 1, -1]
for testCaseCount in range(1,11):
    result = 0
    _ = input()
    li = []
    start = 0
    queue = deque()
    visited=[[False for _ in range(16)] for _ in range(16)]

    for i in range(16):
        tmp = list(map(int, input()))
        li.append(tmp)
        if start == 0 and 2 in tmp:
            y = tmp.index(2)
            visited[i][y] = True
            queue.append([i ,y])

    while(queue):
        curX, curY = queue.popleft()


        for i in range(4):
            nextX = curX + movX[i]
            nextY = curY + movY[i]
            if -1 < nextX < 16 and -1 < nextY < 16:
                if not visited[nextX][nextY]:
                    if li[nextX][nextY] == 0 :
                        visited[nextX][nextY] = True
                        queue.append([nextX, nextY])
                    elif li[nextX][nextY] == 3:
                        result = 1
                        break

    print(f"#{testCaseCount}", result)