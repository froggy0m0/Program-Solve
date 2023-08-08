T = int(input())
for testCaseCount in range(1, T+1):
    N, Q = map(int, input().split())
    boxList = [0 for _ in range(N+1)]
    idx = 0
    for _ in range(Q):
        idx += 1
        L, R = map(int, input().split())
        for i in range(L, R+1):
            boxList[i] = idx

    print(f"#{testCaseCount}", *boxList[1:])