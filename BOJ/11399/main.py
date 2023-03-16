n = int(input())

li = list(map(int, input().split()))
li.sort()


def func():
    cost = 0

    for i in range(0, n):
        cost += li[i] * (n - i)

    return cost


print(func())