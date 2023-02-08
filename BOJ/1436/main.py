import sys

N = int(sys.stdin.readline())

count = 0
res = 0
for i in range(666, 2**31):
    if "666" in str(i) :
        count += 1
        if count == N :
            res = i
            break

print(res)