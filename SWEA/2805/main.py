T = int(input())

for i in range(1, T+1):
    res = 0
    N = int(input())
    farmList = [input() for _ in range(N)]

    width = 1
    baseline = (N-1) // 2
    res = int(farmList[0][baseline])
    for n in range(1, N):
        res += sum([int(farmList[n][i]) for i in range(baseline-width, (baseline+width)+1)])
        if n < baseline:
            width += 1
        else :
            width -= 1

    print(f"#{i}", res)


# T = int(input())
#
# for taseCaseCount in range(1, T+1):
#     N = int(input())
#     li = []
#     for _ in range(N):
#         li.append(list(map(int, input())))
#
#     result = 0
#     baseline = N // 2
#     var = 0
#     for i in range(N):
#         result += sum(li[i][baseline-var:baseline+var+1])
#         if i < baseline :
#             var += 1
#         else :
#             var -= 1
#     print(f"#{taseCaseCount}", result)
