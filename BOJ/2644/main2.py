import sys

n = int(sys.stdin.readline())
targetA, targetB = map(int , sys.stdin.readline().split())
graphList = [[] for _ in range(n+1)]

for i in range(int(sys.stdin.readline())):
    tmpA, tmpB = map(int, sys.stdin.readline().split())
    graphList[tmpA].append(tmpB)
    graphList[tmpB].append(tmpA)

vistedList = [-1 for i in range(n+1)]
vistedList[targetA] = 0

def func(currentNode):
    for nextNode in graphList[currentNode]:
        if vistedList[nextNode] == -1:
            vistedList[nextNode] = vistedList[currentNode] + 1
            func(nextNode)

func(targetA)

print(vistedList[targetB] if vistedList[targetB] != -1 else -1)