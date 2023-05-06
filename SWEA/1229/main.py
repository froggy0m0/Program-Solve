for testCaseCount in range(1, 11):
    N = int(input())
    cryptList = list(map(int, input().split()))

    commandCount = int(input())
    commandList = list(map(str, input().split()))
    for i in range(commandCount):
        tmp = commandList[0]
        x = int(commandList[1])
        y = int(commandList[2])
        if tmp == "I":
            s = list(commandList[3:y+3])
            commandList = commandList[y+3:]
            cryptList = cryptList[:x] + s + cryptList[x:]
        if tmp == "D":
            commandList = commandList[3:]
            cryptList = cryptList[:x] + cryptList[x+y:]

    print(f"#{testCaseCount}", *list(cryptList)[:10])