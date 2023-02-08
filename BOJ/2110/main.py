import sys

N, C = map(int, sys.stdin.readline().split())
location_li = [int(sys.stdin.readline()) for _ in range(N)]
location_li.sort()

low = 0
high = location_li[-1]
res = 0
while (low <= high):
    mid = (low + high) // 2

    tmp = location_li[0]
    count = 1
    for i in range(1, len(location_li)):
        if mid <= location_li[i] - tmp:
            count += 1
            tmp = location_li[i]

        if count >= C:
            res = mid
            break

    if count >= C:
        low = mid + 1
    else:
        high = mid - 1
print(res)