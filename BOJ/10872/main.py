import sys

N = int(sys.stdin.readline())

def func(N):
    if N > 1 :
        return N * func(N - 1)
    else :
        return 1

res = func(N)
print(res)