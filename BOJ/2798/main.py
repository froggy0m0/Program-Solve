import sys
from itertools import combinations

#Input
N, M = map(int, sys.stdin.readline().split())
li = list(map(int, sys.stdin.readline().split()))


com = list(combinations(li, 3))

res = 0
for i in com:
    var_sum = sum(i)
    if var_sum <= M and res < sum(i):
        res = var_sum

print(res)