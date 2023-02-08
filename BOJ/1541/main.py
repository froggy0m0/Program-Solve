import sys

inp_str = sys.stdin.readline().strip()

inp_str = inp_str.split("-")
res = 0
for i in range(len(inp_str)):
    if inp_str[i].find("+") != -1:
        li = inp_str[i].split("+")
        tmp = sum(int(num) for num in li)
    else :
        tmp = int(inp_str[i])

    if i == 0 :
        res = tmp
        continue

    res -= tmp
print(res)