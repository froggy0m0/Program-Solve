import sys


def init_mem():
    mem = [[-1 for i in range(15)] for j in range(15)]

    for i in range(15):
        mem[0][i] = i
        mem[i][1] = 1
        mem[i][0] = 0
        mem[i][2] = i + 2
    return mem


def func(k, n):
    if mem[k][n] != -1:
        return mem[k][n]

    else:
        mem[k][n] = func(k - 1, n) + func(k, n - 1)
        return mem[k][n]


mem = init_mem()

T = int(sys.stdin.readline())

for _ in range(T):
    k = int(sys.stdin.readline())
    n = int(sys.stdin.readline())

    print(func(k, n))