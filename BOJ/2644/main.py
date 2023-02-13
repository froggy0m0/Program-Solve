import sys
from collections import deque

n = int(sys.stdin.readline())
targetA, targetB = map(int , sys.stdin.readline().split())
graphList = [[] for _ in range(n+1)]
for i in range(int(sys.stdin.readline())):
    tmpA, tmpB = map(int, sys.stdin.readline().split())
    graphList[tmpA].append(tmpB)
    graphList[tmpB].append(tmpA)

vistedList = [-1 for i in range(n+1)]
vistedList[targetA] = 0
queue = deque()
queue.append([targetA, graphList[targetA]])

while(queue):
    currentPos, nextNodeList = queue.popleft()
    if currentPos == targetB:
        break

    for nextPos in nextNodeList:
        if vistedList[nextPos] == -1:
            queue.append([nextPos, graphList[nextPos]])
            vistedList[nextPos] = vistedList[currentPos] + 1

print(vistedList[targetB])