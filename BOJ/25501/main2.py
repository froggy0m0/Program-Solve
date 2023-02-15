import sys

T = int(sys.stdin.readline())
li = [sys.stdin.readline().strip() for _ in range(T)]

def func(s, start, end):
    if start >= end : return print(1, len(s)-end)

    if s[start] == s[end] :
        func(s, start+1, end-1)

    else :
        return print(0, len(s)-end)

for s in li:
    func(s, 0, len(s)-1)