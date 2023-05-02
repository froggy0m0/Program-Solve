import sys

def func(teamList):
    result = 0
    for i in teamList:
        for j in teamList:
            if i == j : continue
            else :
                result += li[i][j]

    return result


N = int(sys.stdin.readline())

li = []
for _ in range(N):
    li.append(list(map(int, sys.stdin.readline().split())))

checkList = [None] * (N)
answer = 9999999
for i in range(0, 2**N):
    tmp = bin(i)[2:].zfill(N)
    if tmp.count("0") == N//2:
        AList = []
        BList = []
        for i in range(len(tmp)):
            if tmp[i] == "1":
                AList.append(i)
            else:
                BList.append(i)

        result = abs(func(AList) - func(BList))
        if result < answer:
            answer = result

print(answer)