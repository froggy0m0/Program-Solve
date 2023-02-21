import sys

N = int(sys.stdin.readline())
dp = [i//5 if i%5==0 else 0 for i in range(N+1)]
dp[3] = 1

for i in range(6, N+1):
    if i%5 == 0 : continue

    tmp = 0
    if(dp[i-3]) : tmp = dp[i-3] + 1
    if(dp[i-5]) : tmp = min(dp[i-5]+1, tmp)
    dp[i] = tmp

print(dp[N] if dp[N] else -1)