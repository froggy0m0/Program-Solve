import sys

A, B, V = map(int, sys.stdin.readline().split())

res = 0

V = V - B

res = V / (A-B)
print(int(res) if res%1 == 0 else int(res+1))
