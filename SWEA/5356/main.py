from collections import deque
T = int(input())
for testCaseCount in range(1, T+1):
    queue = deque()
    for _ in range(5):
        queue.append(deque(list(map(str, input()))))
    print(f"#{testCaseCount}", end=" ")

    while(queue):
        tmp = queue.popleft()
        print(tmp.popleft(), end="")
        if (tmp): queue.append(tmp)
    print()