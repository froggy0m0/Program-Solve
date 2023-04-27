T = int(input())


for testCaseCount in range(1, T+1):

    result = 0
    N, M = map(int, input().split())
    li = []

    for _ in range(N):
        li.append(list(map(int, input().split())))

    for i in range(N*N):
        baseX, baseY = i // N, i % N
        tmp = 0

        if baseX+M > N or baseY+M > N :
            continue

        for x in range(baseX, baseX+M):
            for y in range(baseY, baseY + M):
                tmp += li[x][y]

        if tmp > result:
            result = tmp

    print(f"#{testCaseCount}", result)