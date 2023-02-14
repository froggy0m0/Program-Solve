import sys

"""
문제와 반대로
1부터 n 입력된 값까지 곱하거나 더하기로 풀음
"""
sys.setrecursionlimit(10 ** 7)
targetNum = int(sys.stdin.readline())
dp = [i-1 for i in range(targetNum + 1)]  # index 0은 사용안함

for i in range(1, targetNum+1):
    if i+1 <= targetNum and dp[i] + 1 < dp[i+1]:
        dp[i+1] = dp[i] + 1
    if i*2 <= targetNum and dp[i] + 1 < dp[i*2]:
        dp[i*2] = dp[i] + 1
    if i*3 <= targetNum and dp[i] + 1 < dp[i*3]:
        dp[i*3] = dp[i] + 1

print(dp[targetNum])
