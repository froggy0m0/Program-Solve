import sys

def func(k):
    if k == M:
        print(" ".join(map(str, li)))
        return 0

    for i in range(1, N+1):
        if not visited[i]:
            visited[i] = True
            li[k] = i
            func(k+1)
            visited[i] = False

N, M = map(int, sys.stdin.readline().split())
li = [0] * M
visited = [False] * (N+1)

func(0)