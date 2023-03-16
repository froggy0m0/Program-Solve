import sys

n = int(sys.stdin.readline())

def func(n):
    if n > 1 :
        return func(n-2) + func(n-1)
    else : # n <= 1 :
        return n

res = func(n)
print(res)