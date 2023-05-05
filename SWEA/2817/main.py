def func(idx, sum):
    global count

    if sum == targetNum:
        count += 1
        return 0

    if idx == N or sum >targetNum:
        return 0

    func(idx + 1, sum + li[idx])
    func(idx + 1, sum)

T = int(input())
for testCaseCount in range(1,T+1):
    N, targetNum = map(int, input().split())
    li = list(map(int, input().split()))
    count = 0

    func(0, 0)

    print(f"#{testCaseCount}", count)