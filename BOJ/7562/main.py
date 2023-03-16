import sys
from collections import deque

t = int(sys.stdin.readline())


def func():
    l = int(sys.stdin.readline())
    current_pos = list(map(int, sys.stdin.readline().split()))
    target_pos = list(map(int, sys.stdin.readline().split()))
    visited = [[-1 for _ in range(l)] for _ in range(l)]

    dx = [2, 2, -2, -2, 1, -1, 1, -1]
    dy = [1, -1, 1, -1, 2, 2, -2, -2]
    count = 0

    queue = deque()
    queue.append(current_pos + [count])
    visited[current_pos[0]][current_pos[1]] = count

    while (queue):
        current_x, current_y, count = queue.popleft()
        if target_pos[0] == current_x and target_pos[1] == current_y:
            print(count)
            break

        for i in range(len(dx)):
            idx_x = current_x + dx[i]
            idx_y = current_y + dy[i]

            if idx_x > -1 and idx_x < l and idx_y > -1 and idx_y < l and visited[idx_x][idx_y] == -1:
                visited[idx_x][idx_y] = count + 1
                queue.append([idx_x, idx_y, count + 1])


for i in range(t):
    func()