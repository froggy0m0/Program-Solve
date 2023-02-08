import sys

li = [list(map(int, sys.stdin.readline().split())) for _ in range(int(sys.stdin.readline()))]

li.sort(key=lambda x:(x[1], x[0]))

res, cur_time = 1, li[0][1]
for i in range(1, len(li)):
    if cur_time <= li[i][0]:
        cur_time = li[i][1]
        res += 1
print(res)