dic = {"S" : 0, "D" : 1, "H" : 2, "C" : 3}

T = int(input())

for testCaseCount in range(1, T+1):
    li = [[] for _ in range(4)]
    s = input()
    for i in range(0,len(s),3):
        sym = s[i]
        num = s[i+1:i+3]
        li[dic.get(sym)].append(num)

    result = []
    for i in range(len(li)):
        if len(li[i]) != len(set(li[i])):
            print(f"{testCaseCount}", "ERROR")
            break
        result.append(13-len(li[i]))
    else :
        print(f"{testCaseCount}", *result)