for count in range(1, 11):
    _ = input()

    li = []
    li = [list(map(int, input().split())) for _ in range(100)]

    rowSum = [0 for i in range(100)]
    colSum = [0 for i in range(100)]
    diagonalSum = [0,0]

    for i in range(100):
        diagonalSum[0] += li[i][i]
        diagonalSum[1] += li[i][-i]
        for j in range(100):
            rowSum[i] += li[i][j]
            colSum[i] += li[j][i]

    print(f"#{count}", max(max(rowSum), max(colSum), max(diagonalSum)))