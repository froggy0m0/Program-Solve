T = int(input())

for testCaseCount in range(1, T+1):
    N, K = map(int, input().split())
    set1 = {i for i in range(1, N+1)}
    set2 = set(map(int, input().split()))

    print(f"#{testCaseCount}", *set(set1-set2))