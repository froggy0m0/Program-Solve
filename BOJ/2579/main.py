import sys

stairsList = []
n = int(sys.stdin.readline())
for i in range(n):
    stairsList.append(int(sys.stdin.readline()))

if n == 1 :
    print(stairsList[0])
else :
    dp = [[-1 for _ in range(2)]for _ in range(n)]

    dp[0][0] = stairsList[0]
    dp[1][0] = stairsList[1]
    dp[1][1] = stairsList[0] + stairsList[1]

    for i in range(2,n):
        dp[i][0] = max(dp[i-2]) + stairsList[i]
        dp[i][1] = dp[i-1][0] + stairsList[i]
    print(max(dp[n-1][0], dp[n-1][1]))
"""
https://okky.kr/articles/707446

위링크를 보고 푼것이니 나중에 다시풀어보자
"""