import sys

N, M = map(int, sys.stdin.readline().split())

li = list(map(int, sys.stdin.readline().split()))


def func(low, high, key, res=0):
    if low > high:
        return res

    mid = (low + high) // 2
    tmp = sum([i - mid if -1 < i - mid else 0 for i in li])

    if tmp < key:
        return func(low, mid - 1, key, res)
    elif tmp >= key:
        return func(mid + 1, high, key, mid)


res = func(1, max(li), M)
print(res)