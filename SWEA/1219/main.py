from collections import deque

for i in range(1, 11):
    input()
    graphList = [[] for _ in range(100)]
    inp = deque(map(int, input().split()))
    while(inp):
        a, b = inp.popleft(), inp.popleft()
        graphList[a].append(b)

    visitedList = [0 for _ in range(100)]
    visitedList[0] = 1

    queue = deque()
    queue.append(graphList[0])
    while(queue):
        nextPosList = queue.popleft()

        if 99 in nextPosList:
            visitedList[99] = 1
            break

        for nextPos in nextPosList :
            if visitedList[nextPos] == 0:
                visitedList[nextPos] = 1
                queue.append(graphList[nextPos])

    print("#{}".format(i), visitedList[99])