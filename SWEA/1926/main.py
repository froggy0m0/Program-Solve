N = int(input())

li = ['3', '6', '9']

for n in range(1, N+1):
    n = str(n)
    if li in n:
        n = '-' * (n.count('3') + n.count('6') + n.count('9'))
    print(n, end=" ")