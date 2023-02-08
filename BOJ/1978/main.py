import sys

def func(var):
    if var == 1 : return False

    for i in range(2, var):
        if var % i == 0 :
            return False
    return True

N = int(sys.stdin.readline())
li = list(map(int, sys.stdin.readline().split()))


res = 0
for var in li:
    res += 1 if func(var) else 0
print(res)
