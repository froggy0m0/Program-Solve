import sys
import collections

def binary_search(low, high, key, li):
    if low > high : return print("0",end=" ")
    mid = (low + high) // 2

    if li[mid][0] == key : return print(li[mid][1],end=" ")
    elif li[mid][0] > key : return binary_search(low, mid-1, key ,li)
    elif li[mid] [0]< key : return binary_search(mid+1, high, key ,li)

sys.stdin.readline()
N_li = list(map(int , sys.stdin.readline().split()))
N_li = collections.Counter(N_li)
N_li = sorted(N_li.items(), key=lambda x:x[0])

sys.stdin.readline()
M_li = list(map(int , sys.stdin.readline().split()))

for key in M_li:
    binary_search(0, len(N_li)-1, key, N_li)