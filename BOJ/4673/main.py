i = 1
li = set()
while(i <= 10000):
    num = i
    str_num = str(num)
    placeValue = len(str_num)

    for idx in range(placeValue):
        num += int(str_num[idx])
    if num <= 10000:
        li.add(num)
    i+=1

res = sorted(list(set([i for i in range(1,10001)]).difference(li)))
for i in res:
    print(i)