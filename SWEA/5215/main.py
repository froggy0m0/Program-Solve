def func(idx, score, calories):
    global result
    if calories < target:
        result = max(score, result)

    if idx == N:
        return 0

    func(idx+1, score+li[idx][0], calories+li[idx][1])
    func(idx+1, score, calories)


T = int(input())
for testCaseCount in range(1, T+1):
    N, target = map(int, input().split())
    li = []
    for _ in range(N):
        li.append(list(map(int, input().split())))

    result = 0
    func(0, 0, 0)
    print(f"#{testCaseCount}", result)