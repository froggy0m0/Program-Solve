1221dic = {"ZRO":0,"ONE":1,"TWO":2,"THR":3, "FOR":4, "FIV":5, "SIX":6, "SVN":7, "EGT":8, "NIN":9}
baseList = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
T = int(input())
for testCaseCount in range(1, T+1):
    _, length = input().split()
    li = list(map(str, input().split()))
    li.sort(key=lambda x:dic[x])
    # li.sort(key=dic.get)
    # li.sort(key= lambda x:baseList.index(x))

    print(f"#{testCaseCount}\n", *li)