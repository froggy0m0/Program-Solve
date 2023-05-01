for _ in range(10):
    testCastCount = int(input())
    targetStr = list(map(str, input()))
    li = list(map(str, input()))

    count = 0
    for i in range(len(li)-len(targetStr)+1):
        if li[i:i+len(targetStr)] == targetStr:
            count += 1

    print(f"#{testCastCount}", count)