from collections import deque

for testCaseCount in range(1, 11):
    length = int(input())
    cryptogram = list(map(int, input().split()))[:10]
    commandCount = int(input())
    commandQueue = deque(input().split())
    while (commandQueue):
        if(commandQueue[0] == 'I'):
            _, start, count = commandQueue.popleft(), int(commandQueue.popleft()), int(commandQueue.popleft())

        tmp = []

        while(commandQueue[0] != 'I'):
            tmp.append(commandQueue.popleft())
            if len(commandQueue) == 0 : break

        cryptogram = cryptogram[:start] + tmp + cryptogram[start:]
        cryptogram = cryptogram[:10]


    print(f"#{testCaseCount}", *cryptogram)