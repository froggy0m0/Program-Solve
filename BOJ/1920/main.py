import sys

def binary_search(low, high, key, li):
    if low > high : return print("0")
    mid = (low + high) // 2

    if li[mid] == key : return print("1")
    elif li[mid] > key : return binary_search(low, mid-1, key ,li)
    elif li[mid] < key : return binary_search(mid+1, high, key ,li)

sys.stdin.readline()
N_li = sorted(list(map(int , sys.stdin.readline().split())))

sys.stdin.readline()
M_li = list(map(int , sys.stdin.readline().split()))

for key in M_li:
    binary_search(0, len(N_li)-1, key, N_li)