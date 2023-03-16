import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

locationInfo = [i for i in range(101)]
for _ in range(M+N):
    x, y = map(int, sys.stdin.readline().split())
    locationInfo[x] = y

isVisited = [-1 for _ in range(101)]
isVisited[1] = 0
queue = deque()
queue.append(1)
while(queue):
    playerCurrentLocation = queue.popleft()
    for i in range(1,7):
        playerNextLocation = playerCurrentLocation + i
        if playerNextLocation <= 100:
            playerNextLocation = locationInfo[playerNextLocation]
            if isVisited[playerNextLocation] == -1 or isVisited[playerNextLocation] > isVisited[playerCurrentLocation] +1:
                isVisited[playerNextLocation] = isVisited[playerCurrentLocation] + 1
                queue.append(playerNextLocation)
print(isVisited[100])