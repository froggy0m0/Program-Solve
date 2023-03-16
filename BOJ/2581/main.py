import sys

def func(var):
    if var == 1 : return False

    for i in range(2, (var//2)+1):
        if var % i == 0 :
            return False
    return True


M = int(sys.stdin.readline())
N = int(sys.stdin.readline())

res_min = res_sum = 0
for var in range(M, N+1):
    if func(var):
        res_min = var if res_min == 0 else res_min
        res_sum += var

print(f"{res_sum}\n{res_min}" if res_min else -1)