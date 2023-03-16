import sys

N = int(sys.stdin.readline())
N_li = sys.stdin.readline().strip().split(" ")

M = int(sys.stdin.readline())
M_li = sys.stdin.readline().strip().split(" ")

N_li.sort()

def binary_search(low, high, key):
    if low > high :
        return "0"

    mid = (low + high) // 2

    if key == N_li[mid]:
        return "1"
    elif N_li[mid] < key:
        return binary_search(mid+1, high, key)
    else:
        return binary_search(low, mid-1, key)

for num in M_li:
    print(binary_search(0, N-1, num), end=" ")