removes = "aeiou"
T = int(input())

for testCaseCount in range(1, 1+T):
    s = input()
    # s = s.replace("a","").replace("e","").replace("i","").replace("o","").replace("u","")
    print(f"#{testCaseCount}", "".join([x for x in s if x not in removes]))