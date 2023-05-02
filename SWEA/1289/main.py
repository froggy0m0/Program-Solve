T = int(input())

for testCaseCount in range(1,T+1):
    result = 0
    inp = [0]+list(map(int, input()))

    for i in range(0 ,len(inp)-1):
        if inp[i] != inp[i+1]:
            result +=1


    print(f"#{testCaseCount}", result)