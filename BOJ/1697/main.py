import sys
from collections import deque

sys.setrecursionlimit(10**8)

N, K = map(int, sys.stdin.readline().split())
size = 2*max(N,K)
queue = deque()
queue.append([N, 0])
visited = [0 for i in range(size+1)] # max (N,K) ???? 9 4 와같이 뒤에있는경우
while(queue):
    cur_pos, sec = queue.popleft()
    visited[cur_pos] = 1
    if cur_pos == K:
        print(sec)
        break

    if cur_pos-1 >= 0 and visited[cur_pos-1] == 0:
        queue.append([cur_pos-1, sec+1])
    if cur_pos+1 <= K and visited[cur_pos+1] == 0:
        queue.append([cur_pos+1, sec+1])
    if 2*cur_pos <= size and visited[2*cur_pos] == 0:
        queue.append([2*cur_pos, sec+1])