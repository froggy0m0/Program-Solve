from collections import deque

for count in range(1,11):
    _ = input()
    queue = deque()
    inp = list(map(int, input().split()))
    for num in inp:
        queue.append(num)

    i = 1
    while(True):
        if queue[-1] <= 0:
            queue[-1] = 0
            break
        queue.append(queue.popleft()-i)
        if i == 5 :
            i = 1
        else :
            i+=1

    queue[-1] = 0
    print(f"#{count}", *queue)