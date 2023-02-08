import sys

N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
res = 0
low = 0
high = K

while (low <= high):
    mid = (low + high) // 2
    count = 0

    for i in range(1, N + 1):
        tmp = min(mid // i, N)
        count += tmp
        if tmp == 0:
            break

    if count < K:
        low = mid + 1
    else:
        res = mid
        high = mid - 1

print(res)