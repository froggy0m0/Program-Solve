for testCaseCount in range(1, 11):
    result=0
    tmp_li = []

    _ = input()
    for i in range(100):
        tmp_li.append(input().split())

    li = list(map(list, zip(*tmp_li)))
    for i in li:
        s = "".join(i).replace("0","")
        result += s.count("12")

    print(f"#{testCaseCount}", result)