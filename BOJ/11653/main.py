import sys


def func(N):
    for i in range(2, (N // 2) + 1):
        if N % i == 0:
            li.append(i)
            return func(N // i)

    li.append(N)


li = []
N = int(sys.stdin.readline())
func(N)
if li[0] != 1:
    for i in li:
        print(i)