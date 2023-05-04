from collections import deque

def bfs(x, visitedList):
    global result
    if len(visitedList) > result:
        result = len(visitedList)

    for y in mapList[x]:
        if y not in visitedList:
            bfs(y, visitedList+[y])

T = int(input())
for testCaseCount in range(1,T+1):
    N, M = map(int, input().split())

    mapList = [[] for _ in range(N+1)]
    for _ in range(M):
        x, y = map(int, input().split())
        mapList[x].append(y)
        mapList[y].append(x)
    result = 0
    for x in range(1, N+1):
        bfs(x, [x])


    print(f"#{testCaseCount}", result)