import sys
from itertools import combinations

N = int(sys.stdin.readline())

n_digits = len(str(N))

start = 0 if N < 18 else N - (n_digits * 9)
end = N + 1


def func(start, end):
    res = 2 ** 31
    for i in range(start, end):
        var_sum = i + sum([int(j) for j in str(i)])
        if var_sum == N and i < res:
            res = i
    return res


res = func(start, end)
print(0 if res == 2 ** 31 else res)