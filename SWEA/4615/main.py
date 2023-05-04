def fillMap(x, y, color):
    mapList[x][y] = color

def checkLimit(x, y):
    if -1 < x < N and -1 < y < N:
        return True
    else:
        return False

def reverse(x, y, color):
    fillMap(x,y, color)

    for stepX, stepY in zip(dx, dy):
        tmp = []
        for mul in range(1, N):
            nx = x + (stepX * mul)
            ny = y + (stepY * mul)
            if checkLimit(nx, ny):
                if mapList[nx][ny] == 0:
                    break

                elif mapList[nx][ny] != color:
                    tmp.append([nx,ny])

                elif mapList[nx][ny] == color:
                    while(tmp):
                        tmpX, tmpY = tmp.pop()
                        fillMap(tmpX, tmpY, color)
                    break
            else :
                break

dx = [-1, +1, +0, +0, -1, -1, +1, +1] #상하좌우 대각선4
dy = [+0, +0, -1, +1, -1, +1, +1, -1]

B = 1
W = 2

T = int(input())

for testCaseCount in range(1, T+1):
    N, M = map(int, input().split())
    mapList = [[0 for _ in range(N)] for _ in range(N)]

    baseline = N // 2
    mapList[baseline-1][baseline-1] = W
    mapList[baseline][baseline] = W
    mapList[baseline-1][baseline] = B
    mapList[baseline][baseline-1] = B

    resultW = 0
    resultB = 0

    for _ in range(M):
        x, y, color = map(int, input().split())
        reverse(x-1, y-1, color)


    for i in mapList:
        resultW += i.count(W)
        resultB += i.count(B)

    print(f"#{testCaseCount}", resultB, resultW)