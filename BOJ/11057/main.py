import sys

dp = [1 for _ in range(10)]
N = int(sys.stdin.readline())
for i in range(1, N):
    for j in range(1, 10):
        dp[j] += dp[j-1]

print(sum(dp) % 10007)