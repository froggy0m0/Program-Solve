for testCaseNumber in range(1, 11): #11):
    targetDumpCount = int(input())
    boxCountList = [0 for _ in range(101)]

    tmpList = sorted(list(map(int, input().split())))
    minValue, maxValue = tmpList[0], tmpList[-1]
    for count in tmpList:
        boxCountList[count] += 1

    currentDumpCount = 0
    while(currentDumpCount < targetDumpCount):
        subtractValue = min(boxCountList[minValue], boxCountList[maxValue], targetDumpCount-currentDumpCount)
        boxCountList[minValue] -= subtractValue
        boxCountList[maxValue] -= subtractValue
        boxCountList[minValue+1] += subtractValue
        boxCountList[maxValue-1] += subtractValue
        currentDumpCount += subtractValue

        if boxCountList[minValue] == 0:
            while(boxCountList[minValue] == 0) : minValue += 1
        if boxCountList[maxValue] == 0:
            while(boxCountList[maxValue] == 0) : maxValue -= 1

    print(f"#{testCaseNumber}", maxValue - minValue)