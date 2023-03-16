import sys

def func(H, W, N):

    B,A = divmod(N, H)

    if A == 0:
        A = H
        B -= 1

    res = str(B+1).zfill(2)
    res = str(A) + res

    return res

T = int(sys.stdin.readline())

for _ in range(T):
    H, W, N = map(int, sys.stdin.readline().split())
    res = func(H, W, N)

    print(res)