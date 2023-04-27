import sys

def func(k):
    if k == M :
        print(" ".join(map(str, li)))
        return 0

    for i in range(1, N+1):
        if not visited[i]:
            visited[i] = True
            if k == 0 or li[k-1] < i:
                li[k] = i
                func(k+1)
            visited[i] = False


N, M = map(int, sys.stdin.readline().split())
li = [None] * M
visited = [False] * (N+1)
func(0)