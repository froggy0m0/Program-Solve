T = int(input())
for testCaseCount in range(1,T+1):
    L, U, X = map(int, input().split())
    if X < L :
        result = L-X
    elif L <= X <= U :
        result = 0
    elif L < X :
        result = -1

    print(f"#{testCaseCount}", result)
