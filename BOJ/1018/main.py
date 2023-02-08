import sys


M, N = map(int, sys.stdin.readline().split())

li=[]
for i in range(M):
    li.append(sys.stdin.readline().strip())

def func(x, y):
    count = 0
    for m in range(0, 8):
        for n in range(0, 8):
            if (m+x)%2 == 0 :
                if "BWBWBWBW"[n] == li[m+x][n+y] :
                    count += 1
            elif (m+x)%2 != 0 :
                if "WBWBWBWB"[n] == li[m+x][n+y] :
                    count += 1
    res =  count if count <= 32 else 64-count
    return res

res = 99999
for x in range(0, (M-8)+1):
    for y in range(0, (N-8)+1):
        tmp = func(x,y)
        res = tmp if tmp < res else res

print(res)