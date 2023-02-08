import sys
from collections import deque

N = int(sys.stdin.readline())
taskList = [list(map(int, sys.stdin.readline().split())) for _ in range(N)] # [[T1, P1], [T2,P2]....]

def func():
    queue = deque()
    queue.append([])