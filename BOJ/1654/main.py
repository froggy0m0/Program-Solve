import sys

K, N = map(int, sys.stdin.readline().split())
li = [int(sys.stdin.readline()) for i in range(K)]
li.sort()

def find(low, high, key, li, res=0):
    if low > high :
        return res

    mid = (low + high) // 2
    if mid == 0 : return 1

    tmp = sum([(i//mid) for i in li])

    if tmp < key:
        return find(low, mid-1, N, li, res)
    elif tmp >= key:
        return find(mid+1, high, N, li, mid)

res = find(0, li[-1], N, li)
print(res)