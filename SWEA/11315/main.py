dx = [+1, -1, +0, +0, +1, +1, -1, -1]
dy = [+0, +0, +1, -1, +1, -1, -1, +1]


def func(x, y):
    if li[x][y] == ".": return False
    count = 0
    for i in range(len(dx)):
        checkX = x + (dx[i] * 4)
        checkY = y + (dy[i] * 4)
        if -1 < checkX < N and -1 < checkY < N:
            for step in range(5):
                nx = x + (dx[i] * step)
                ny = y + (dy[i] * step)
                if li[nx][ny] == "o":
                    count += 1
            if count == 5:
                return True
            else:
                count = 0

    return False


T = int(input())
for testCaseCount in range(1, T + 1):
    N = int(input())
    li = []
    for _ in range(N):
        li.append(list(map(str, input())))
    result = False
    for x in range(N):
        if (result): break
        for y in range(N):
            result = func(x, y)
            if (result == True): break

    print(f"#{testCaseCount}", "YES" if result else "NO")