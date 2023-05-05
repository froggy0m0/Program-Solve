from collections import deque

T = int(input())
for testCaseCount in range(1, T+1):
    N = int(input())
    li = list(map(str, input().split()))

    # half = N // 2 if N % 2 == 0 else (N // 2) +1
    half = (N+1) // 2

    print(f"#{testCaseCount}", end=" ")
    li1 = deque(li[:half])
    li2 = deque(li[half:])
    while(li1 or li2):
        if(li1):
            print(li1.popleft(), end=" ")
        if(li2):
            print(li2.popleft(), end=" ")
    print()

