import sys
N = int(sys.stdin.readline())

distance_li = [0]
distance_li += map(int, sys.stdin.readline().split())

count_li = list(map(int, sys.stdin.readline().split()))

res = 0
pos = 0
for i in range(N):
    if i == 0:
        min_cost = count_li[0]
        continue

    if min_cost > count_li[i] or i == N-1:
        sum_li = distance_li[pos+1:i+1]
        sum_res = sum(sum_li)
        res += min_cost * sum_res
        pos = i
        min_cost = count_li[i]
    else :
        continue

print(res)