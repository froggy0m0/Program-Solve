import sys

dp = [0 for _ in range(41)]
dp[1] = dp[2] = 1
count = 0
def fib(n):
    global count
    for i in range(3, n+1):
        count += 1
        dp[i] = dp[i-1] + dp[i-2]
    return dp[n]
n = int(sys.stdin.readline())
print(fib(n), count)