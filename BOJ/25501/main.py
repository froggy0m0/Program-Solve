import sys

T = int(sys.stdin.readline())
stringList = [sys.stdin.readline().strip() for i in range(T)]

def func(s, count=1):
    slen = len(s)
    if count > len(s)//2:
        return [1, count]
    if s[count-1] == s[slen - count]:
        return func(s, count+1)
    else :
        return [0, count]

for s in stringList:
    print(*func(s))