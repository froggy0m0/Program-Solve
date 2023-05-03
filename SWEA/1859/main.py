T = int(input())
for testCastCount in range(1, T+1):
    N = int(input())
    li = list(map(int, input().split()))
    answer = 0
    while(li):
        maxValue = max(li)
        maxIdx = li.index(maxValue)
        if maxIdx == 0:
            li = li[1:]
            continue
        if maxValue == 0: break
        answer += (maxValue * maxIdx-sum(li[:maxIdx]))
        li = li[maxIdx+1:]
        maxValue = 0

    print(f"#{testCastCount}", answer)