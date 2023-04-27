import sys

N, M = map(int, sys.stdin.readline().split())

li = sorted(list(map(int, sys.stdin.readline().split())))
result = []

def func(idx):
    if len(result) == M:
        print(*result)
        return 0

    for i in range(idx, len(li)):
        result.append(li[i])
        func(i+1)
        result.pop()

func(0)