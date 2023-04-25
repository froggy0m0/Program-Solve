T = int(input())

for testCaseCount in range(1,T+1):
    N = int(input())
    li = [[-1 for _ in range(N)] for _ in range(N)]

    x = 0
    y = 0
    tmp = [[0,1], [1,0], [0,-1], [-1,0]]
    count = 0
    num = 1
    li[0][0] = num
    while(num != N*N):
        next_x = x+tmp[count % 4][0]
        next_y = y+tmp[count % 4][1]

        if (0 <= next_x <= N-1) and (0 <= next_y <= N-1) and li[next_x][next_y] == -1:
            x = next_x
            y = next_y
            num += 1
            li[x][y] = num
        else :
            count += 1

    print(f"#{testCaseCount}")
    for i in li:
        print(*i)