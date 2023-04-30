import sys

N = int(sys.stdin.readline())
nList = sorted(list(map(int, sys.stdin.readline().split())))

M = int(sys.stdin.readline())
mList = list(map(int, sys.stdin.readline().split()))


def lower_idx(targetNum):
    start = 0
    end = len(nList)
    while(start < end):
        mid = (start+end) // 2

        if nList[mid] >= targetNum : end = mid
        else : start = mid +1

    return start

def upper_idx(targetNum):
    start = 0
    end = len(nList)
    while(start < end):
        mid = (start+end) // 2

        if(nList[mid] > targetNum) : end = mid
        else : start = mid +1

    return start

for num in mList:
    print(upper_idx(num)-lower_idx(num), end=" ")