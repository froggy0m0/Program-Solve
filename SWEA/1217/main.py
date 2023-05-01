def func(N, M, count):
    global result
    if M == count :
        return
    result *= N
    func(N, M, count+1)


for _ in range(10):
    testCaseCount = int(input())
    N, M = map(int, input().split())
    result = N
    func(N,M, 1)

    print(f"#{testCaseCount}", result)