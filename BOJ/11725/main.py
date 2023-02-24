import sys
from collections import deque

N = int(sys.stdin.readline())
graphList = [[] for _ in range(N+1)]
for _ in range(N-1):
    A, B = map(int, sys.stdin.readline().split())
    graphList[A].append(B)
    graphList[B].append(A)

visitedList = [0 for _ in range(N+1)]

queue = deque()
queue.append(1)
while(queue):
    curPos = queue.popleft()

    for nextPos in graphList[curPos]:
        if not visitedList[nextPos]:
            queue.append(nextPos)
            visitedList[nextPos] = curPos
for i in range(2, N+1):
    print(visitedList[i])