import sys

N, M = map(int, sys.stdin.readline().split())
li = [None] * M

def func(k):
    if k == M:
        print(*li)
        return 0

    for i in range(1, N+1):
        li[k] = i
        func(k+1)
func(0)