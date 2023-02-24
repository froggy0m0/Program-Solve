import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())
graphList = [[] for _ in range(N+1)]
for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    graphList[B].append(A)

def bfs(curPos):
    visitedList = [False for _ in range(N+1)]
    visitedList[curPos] = True
    count = 0

    queue = deque()
    queue.append(curPos)
    while(queue):
        nextPosList = queue.popleft()
        for nextPos in graphList[nextPosList]:
            if visitedList[nextPos] == False :
                visitedList[nextPos] = True
                count += 1
                if graphList[nextPos]:
                    queue.append(nextPos)
    return count

maxCount = 1
resultList = []
for i in range(1, N+1):
    tmpCount = bfs(i)

    if tmpCount > maxCount :
        maxCount = tmpCount
        resultList = [i]
    elif tmpCount == maxCount :
        resultList.append(i)

print(*resultList)