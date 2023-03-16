from collections import deque

for testCaseNum in range(1, 11):
    N = int(input())
    buildingList = list(map(int, input().split()))
    res = 0
    queue = deque([buildingList[i] for i in range(4)])
    for i in range(4, N):
        queue.append(buildingList[i])
        maxValue = max([queue[i] for i in range(5) if i != 2])

        res += queue[2] - maxValue if queue[2] > maxValue else 0
        queue.popleft()
    print(f"#{testCaseNum}", res)