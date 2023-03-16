import sys
from math import sqrt

#input
inp = []
for i in range(int(sys.stdin.readline())):
    inp.append(int(sys.stdin.readline()))
var_max = max(inp)

#initizlization
li = [i for i in range(0,var_max+1)]
li[0]=li[1] = None

#find prime Number
for i in range(2, int(sqrt(var_max))+1):
    for j in range(i+i, len(li), i):
        if li[j] != None :
            li[j] = None

def find_goldbach(N):
    for i in range(N//2, 0, -1):
        if li[i] != None and N-i in li:
            print(i,N-i)
            break
        else:
            continue

for N in inp:
    find_goldbach(N)