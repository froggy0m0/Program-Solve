T = int(input())

for testCaseCount in range(1, 1+T):
    N, K = map(int, input().split())
    li = sorted(list(map(int, input().split())), reverse=True)

    print(f"#{testCaseCount}", sum(li[:K]))