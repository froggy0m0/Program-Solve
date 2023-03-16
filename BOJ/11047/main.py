import sys

n, k = map(int, sys.stdin.readline().split())

li = [int(sys.stdin.readline().strip()) for _ in range(n)]

res = 0
for i in reversed(li):
    if k == 0 : break
    tmp, k = divmod(k,i)
    res += tmp

print(res)